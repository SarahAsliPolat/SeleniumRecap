package com.cybertek.tests.day4_FindElements_Checkboxes_Radio;

import com.cybertek.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class P0_FindElementsPractice {
    public static void main(String[] args) {


        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        driver.manage().window().maximize();

        //print out the texts of web elements we just created above

        List<WebElement> listOfLinks = driver.findElements(By.xpath("//body//a"));
        //looping through the list of web elements we just created above
        for(WebElement eachLink: listOfLinks){
            //Getting the text of each element in each iteration, and print values
            System.out.println(eachLink.getText());//because we want the list of the links as a text we use getText
        }
        //print out how many total link
        //System.out.println(listOfLinks.size());
        //to make it more readble

        int numberOfLinks= listOfLinks.size();
        System.out.println("numberOfLinks = " + numberOfLinks);



    }

}
