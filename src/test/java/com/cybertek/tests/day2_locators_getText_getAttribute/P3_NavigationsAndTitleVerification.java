package com.cybertek.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P3_NavigationsAndTitleVerification {
    public static void main(String[] args) throws InterruptedException {

        //LINK TEXT LOCATOR IS FOR ANCHORE TAGS ONLY. IT HAS TO BE A LINK IN ORDER TO BE ABLE USE AS A LOCATOR-IT RETURNS A WEB ELEMENT
        //Back and forth navigation
      //setup the browser driver
        WebDriverManager.chromedriver().setup();

        //open browser and create an instance of the driver
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.google.com");

        //click to gmail from top right-WE LOCATED GMAIL LINK WEB ELEMENT USING LINK TEXT
        driver.findElement(By.linkText("Gmail")).click();//before typing Gmail go to the website and inspect-right click->inspect; you have to make sure it is an anchor tag<a- that means it is a link-clickable and takes you somewhere else when you click on it

        //verify title; Gmail
        String expectedInTitle ="Gmail";
        String actualTitle= driver.getTitle();

        if (actualTitle.contains(expectedInTitle)) {
            System.out.println("Title test passed");
        }else {
            System.out.println("Title test failed");
        }
        driver.navigate().back();
        Thread.sleep(3000);
        driver.navigate().forward();

        String actualUrl= driver.getCurrentUrl();
        String expectedUrl= "google.com";

        if(actualUrl.contains(expectedUrl)) {
            System.out.println("url test passed");
        }else {
            System.out.println("url test failed");
        }

     //PARTIAL LINK TEXT LOCATOR: LIKE CONTAINS. PART OF THE TEXT MATCH IS ENOUGH
        driver.findElement(By.partialLinkText("Sign")).click();

        driver.findElement(By.name("JFyozc")).click();


    }
}
