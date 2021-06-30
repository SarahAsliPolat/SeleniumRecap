package com.cybertek.tests.day10_testbase_properties_driverUtil;

import com.cybertek.Utilities.ConfigurationReader;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadingProperties {

    @Test
    public void reading_from_properties_file() throws IOException {
        //properties:use properties class object
        Properties properties=new Properties();//we create properties object to be able to read configuration.properties file.import from java.util

        //FileInputStream:opens the file
        String path ="configuration.properties";
        FileInputStream file =new FileInputStream(path);//it makes us to read file

        //we will load the file
        properties.load(file);

        //read from the file
        System.out.println("properties.getProperty(\"username\") = " + properties.getProperty("username"));
        System.out.println("properties.getProperty(\"browser\") = " + properties.getProperty("browser"));

        //close the file
        file.close();




    }


    @Test
    public void using_properties_utility_method(){

        System.out.println("ConfigurationReader.getProperty(\"browser\") = " + ConfigurationReader.getProperty("browser"));
        System.out.println("ConfigurationReader.getProperty(\"smartbearUrl\") = " + ConfigurationReader.getProperty("smartbearUrl"));
        System.out.println("ConfigurationReader.getProperty(\"username\") = " + ConfigurationReader.getProperty("username"));

    }
}
