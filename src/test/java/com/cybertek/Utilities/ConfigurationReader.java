package com.cybertek.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    //#1- We created the properties object
    private static Properties properties = new Properties();

    static { //static block runs before everything else and initializes everything in it.i need a block in order to be able to write a java code. second reason; we are going to open a file, load and read from it and i need them to happen before everything else.they have to be ready for my source code to use it
        try {
            //#2- We get the path and pass it into FileInputStream, to open the file
            FileInputStream file = new FileInputStream("configuration.properties");
            //#3- We load the opened file into properties object
            properties.load(file);
            //#5- close the file
            file.close();

        } catch (IOException e) {
            System.out.println("Properties file not found.");
        }
    }
    //#4- We read from file: we will be creating a utility method for reading.
    public static String getProperty(String keyWord){
        return properties.getProperty(keyWord);
    }


}