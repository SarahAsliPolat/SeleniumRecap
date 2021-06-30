package com.cybertek.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class SmartBearUtilities {


    public static void loginToSmartBear(WebDriver driver){


        WebElement userNameInput= driver.findElement(By.id("ctl00_MainContent_username"));
        userNameInput.sendKeys("Tester");

        //enter password "test"
        WebElement password =driver.findElement(By.id("ctl00_MainContent_password"));
        password.sendKeys("test");

        //click to login button
        WebElement logInButton=driver.findElement(By.id("ctl00_MainContent_login_button"));
        logInButton.click();

    }

    public static void verifyOrder(WebDriver driver, String name){
        //created a locator for the names on the list
       List<WebElement> namesList= driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[2]"));
       //if there were only one "table" we woudlnt need to locate the tab;e//tr/td[2] would work as an xpath

        for(WebElement each:namesList) {
            if (each.getText().equalsIgnoreCase(name)) {
                Assert.assertTrue(true);
                return;//we want to exit the method so added return, so if the 'if' condition is true it will not execute the rest will exit the method, if the 'if' condition is false will exit the method and execute the test failure msg/ if we were trying to break the loop we would use break
            }
        }
        Assert.fail("name doesn't exist in the list");

    }

    public static void printNamesAndCities(WebDriver driver){
        List<WebElement> namesList =driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[2]"));

        List<WebElement> citiesList= driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[7]"));

        for(int i=0; i<namesList.size();i++){
            System.out.println("Name: "+(i+1)+namesList.get(i).getText()+" Cities: "+(i+1)+citiesList.get(i).getText());

        }
    }
}
