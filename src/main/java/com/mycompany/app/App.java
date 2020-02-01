package com.mycompany.app;
import java.util.ArrayList;
import java.util.Collections;


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
