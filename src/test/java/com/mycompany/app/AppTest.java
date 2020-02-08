package com.mycompany.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.lang.Exception;
/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName ) {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite( AppTest.class );
    }

    public void testSum(){
      ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(2,4,7,1,3,43,23,12,6));
      ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(23,5,10,29,7,4,0,11,9));
      assertTrue(App.findSum(list1,list2,1,1) == 1) ;
      assertTrue(App.findSum(list1,list2,3,2) == 7) ;
    }

    public void testNotSum(){
      ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(2,4,7,1,3,43,23,12,6));
      ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(23,5,10,29,7,4,0,11,9));
      assertFalse(App.findSum(list1,list2,1,1) == 10) ;
      assertFalse(App.findSum(list1,list2,3,2) == 0) ;
    }

    public void testArraysNull(){
        try{
          App.findSum(null,null,5,6);
          fail("Missing Exception");
        }catch(IllegalArgumentException e){
            //success
        }
    }

    public void testKeyisLarger(){
      ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(2,4,7,1,3,43,23,12,6));
      ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(23,5,10,29,7,4,0,11,9));

      try{
        App.findSum(list1,list2,1,60);
        fail("Missing Exception");
      }catch(IllegalArgumentException e){
         //success
      }
    }
    public void testKeyisSmaller(){
      ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(2,4,7,1,3,43,23,12,6));
      ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(23,5,10,29,7,4,0,11,9));

      try{
        App.findSum(list1,list2,0,6);
        fail("Missing Exception");
      }catch(IllegalArgumentException e){
         //success
      }
    }





}
