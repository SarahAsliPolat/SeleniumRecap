package com.cybertek.tests.day5_TestNG_Intro;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNG_Intro {



    @BeforeClass//it runs once before everything..any setup stuff can be handled in the before class
    public void setUpClass(){
        System.out.println("before class is running");

    }
    @AfterClass//it runs once after everything is done..teardown(closing) stuff can be handled in this method
    public void tearDownClass(){
        System.out.println("After class method is running");
    }

    @BeforeMethod//runs before each test
    public void setUpMethod(){
        System.out.println("before method is running...");
    }

    @AfterMethod//runs after each test
    public void tearDownMethod(){
        System.out.println("After method is running...");
    }

   @Test
    public void test1(){
       System.out.println("Test1 is Running...");
    }

    @Test
    public void test2(){
        System.out.println("Test2 is Running...");

    }

    @Test
    public void test3 (){
        String str1 = "TestNG";
        String str2= "TestNG";
        String str3 = "test";
//YOU CAN HAVE MORE THAN 1 ASSERTION IS ONE TEST BUT IF ONE OF THEM FAILS IT WILL STOP EXECUTION. IT WON'T RUN THE REST
        Assert.assertTrue(str1.equals(str2));
        Assert.assertTrue(str1.equals(str3),"str1 is not equal to str3");//

        Assert. assertEquals(str1,str2,"Failure msg in case str1 and str2 are not equal");



    }
}
