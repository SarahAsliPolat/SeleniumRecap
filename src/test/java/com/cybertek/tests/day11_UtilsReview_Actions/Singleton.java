package com.cybertek.tests.day11_UtilsReview_Actions;

import org.testng.annotations.Test;

public class Singleton {

    private Singleton(){}//making the constructor private so we limit creating objects from this class

    //if this class was containing sensitive information in order to protect the information we make the String private than we create a getter method and allow user to get part or the version of the info you want by creating an object and assigning the info yoy want to share. here we have word="hello hello" this what we want to share with user
    private static String word;//making the string public so that we can only reach this using getter method

    public static String getWord() {//creating a getter method to allow users to reach private String above
        if (word == null) {
            System.out.println("first time call. word object is null. " + "assigning value to it now");
            word = "hello hello ";

        }else {
            System.out.println("word already has value");

        }
        return word;
    }

    @Test
    public void singleton_tst2(){

        String str4= Singleton.getWord();
        System.out.println("str4 = " + str4);

    }



}
