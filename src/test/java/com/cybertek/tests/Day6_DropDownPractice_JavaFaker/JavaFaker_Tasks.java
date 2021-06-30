package com.cybertek.tests.Day6_DropDownPractice_JavaFaker;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class JavaFaker_Tasks {

    @Test
    public void faker_test(){
        Faker faker = new Faker();

       String firstName=  faker.name().firstName();
        System.out.println("first Name: "+firstName);

        String lastName =faker.name().lastName();
        System.out.println("last name: "+ lastName);

        String fullName= faker.name().fullName();
        System.out.println("fullName = " + fullName);

        String address= faker.address().fullAddress();
        System.out.println("address = " + address);

        String house = faker.gameOfThrones().house();
        System.out.println("house = " + house);

        String quote =faker.gameOfThrones().quote();
        System.out.println("quote = " + quote);

        String fact= faker.chuckNorris().fact();
        System.out.println("fact = " + fact);


    }
    @Test
    public void faker_practice(){

        Faker faker = new Faker();

        String name = faker.name().firstName();
        System.out.println("name = " + name);


    }
}
