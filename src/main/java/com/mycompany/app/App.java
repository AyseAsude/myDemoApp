package com.mycompany.app;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;


public class App extends Exception {
    public static void main(String[] args) {

        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(5);
        list1.add(2);
        list1.add(18);
        list1.add(20);
        list1.add(51);
        list1.add(40);
        list1.add(3);
        list1.add(10);
        list1.add(16);

        ArrayList<Integer> list2= new ArrayList<>();
        list2.add(11);
        list2.add(28);
        list2.add(43);
        list2.add(82);
        list2.add(1);
        list2.add(9);
        list2.add(12);
        list2.add(5);
        list2.add(8);

        System.out.println(findSum(list1,list2,2,1));
        port(getHerokuAssignedPort());

        get("/", (req, res) -> "Hello, World");

        post("/compute", (req, res) -> {
        //System.out.println(req.queryParams("input1"));
        //System.out.println(req.queryParams("input2"));

        String input1 = req.queryParams("input1");
        java.util.Scanner sc1 = new java.util.Scanner(input1);
        sc1.useDelimiter("[;\r\n]+");
        java.util.ArrayList<Integer> inputList = new java.util.ArrayList<>();
        while (sc1.hasNext())
        {
          int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
          inputList.add(value);
        }
        System.out.println(inputList);


        String input2 = req.queryParams("input2");
        java.util.Scanner sc2 = new java.util.Scanner(input2);
        sc2.useDelimiter("[;\r\n]+");
        java.util.ArrayList<Integer> inputList2 = new java.util.ArrayList<>();
        while (sc2.hasNext())
        {
          int value = Integer.parseInt(sc2.next().replaceAll("\\s",""));
          inputList2.add(value);
        }
        System.out.println(inputList2);

        String input3 = req.queryParams("input3").replaceAll("\\s","");
        int input3AsInt = Integer.parseInt(input3);
        String input4 = req.queryParams("input4").replaceAll("\\s","");
        int input4AsInt = Integer.parseInt(input4);
        int result = App.findSum(inputList, inputList2,input3AsInt,input4AsInt);

        Map map = new HashMap();
        map.put("result", result);
        return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());


       get("/compute",
          (rq, rs) -> {
            Map map = new HashMap();
            map.put("result", "not computed yet!");
            return new ModelAndView(map, "compute.mustache");
          },
          new MustacheTemplateEngine());
  }

  static int getHerokuAssignedPort() {
      ProcessBuilder processBuilder = new ProcessBuilder();
      if (processBuilder.environment().get("PORT") != null) {
          return Integer.parseInt(processBuilder.environment().get("PORT"));
      }
      return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
   }


    public static int findSum(ArrayList<Integer> list1, ArrayList<Integer> list2, int smallestk1, int smallestk2) throws IllegalArgumentException{
       if(list1 == null || list2 == null){
          throw new IllegalArgumentException("arraylist cannot be null");
        }else if( (smallestk1 > list1.size() || smallestk2 > list2.size()) || (smallestk1 <= 0  || smallestk2 <= 0) ){
            throw new IllegalArgumentException("keys cannot be smaller or greater than the array's size");
        }
        Collections.sort(list1);
        Collections.sort(list2);
        return list1.get(smallestk1-1) + list2.get(smallestk2-1);
    }
}
