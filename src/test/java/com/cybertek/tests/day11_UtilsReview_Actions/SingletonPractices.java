package com.cybertek.tests.day11_UtilsReview_Actions;

import org.testng.annotations.Test;

public class SingletonPractices {


    @Test
    public void singleton_test1() {
        String str1 = Singleton.getWord();
        System.out.println("str1 = " + str1);

        String str2 = Singleton.getWord();
        System.out.println("str2 = " + str2);

        String str3 = Singleton.getWord();
        System.out.println("str3 = " + str3);


    }

    @Test

    public void singleton_test2() { //when i run it first time it will say the object is null because it is th beginning of a new test

        String str4 = Singleton.getWord();
        System.out.println("str4 = " + str4);


    }
}