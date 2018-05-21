import spark.ModelAndView;
import spark.Spark;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import static spark.Spark.get;
import static spark.Spark.staticFileLocation;

public class Controller {

    public static void main(String[] args) {
        VelocityTemplateEngine velocityTemplateEngine = new VelocityTemplateEngine();
        staticFileLocation("/public");

        Person person1 = new Person("Dragon");
        Person person2 = new Person("His Royal Highness : Edwardo thee 7th");
        Person person3 = new Person("Brido");
        Person person4 = new Person("Paulo Nutini");
        Person person5 = new Person("Paddy");
        Person person6 = new Person("Andy");
        Person person7 = new Person("Stewbo");
        Person person8 = new Person("Sazzo");
        Person person9 = new Person("Lieutenant Dan");
        Person person10 = new Person("Posh Lyle");
        Person person11 = new Person("Kelso");
        Person person12 = new Person("Scotty2Hotty");
        Person person13 = new Person("Chrissy");
        Person person14 = new Person("That Guy Aka Ruaridh");
        Person person15 = new Person("Nik-Cool");
        Person person16 = new Person("Callum");
        Person person17 = new Person("Berto");
        Person person18 = new Person("Mad Fraz");
        Person person19 = new Person("Conna");

        ArrayList<Person> allThePeople = new ArrayList<>();

        allThePeople.add(person1);
        allThePeople.add(person2);
        allThePeople.add(person3);
        allThePeople.add(person4);
        allThePeople.add(person5);
        allThePeople.add(person6);
        allThePeople.add(person7);
        allThePeople.add(person8);
        allThePeople.add(person9);
        allThePeople.add(person10);
        allThePeople.add(person11);
        allThePeople.add(person12);
        allThePeople.add(person13);
        allThePeople.add(person14);
        allThePeople.add(person15);
        allThePeople.add(person16);
        allThePeople.add(person17);
        allThePeople.add(person18);
        allThePeople.add(person19);

        Collections.shuffle(allThePeople);

        get("/random-a-tron", (req, res) -> {

            HashMap<String, Object> model = new HashMap<>();
            model.put("allThePeople", allThePeople);
            model.put("randomtemplate", "randomatron.vtl");
            return new ModelAndView(model, "layout.vtl");

        }, velocityTemplateEngine);

        get("/random-a-tron/one", (req, res) -> {

            Collections.shuffle(allThePeople);
            Object result = allThePeople.get(0).getName();
            HashMap<String, Object> model = new HashMap<>();
            model.put("result", result);
            model.put("randomtemplate", "onename.vtl");
            return new ModelAndView(model, "onename.vtl");
        }, velocityTemplateEngine);


        get("random-a-tron/pair", (req, res) -> {

            Collections.shuffle(allThePeople);
            String result = allThePeople.get(0).getName();
            String result2 = allThePeople.get(1).getName();
            HashMap<String, Object> model = new HashMap<>();
            model.put("result", result);
            model.put("result2", result2);
            model.put("randomtemplate", "onepair.vtl");
            return new ModelAndView(model, "onepair.vtl");
        }, velocityTemplateEngine);
    }
}
