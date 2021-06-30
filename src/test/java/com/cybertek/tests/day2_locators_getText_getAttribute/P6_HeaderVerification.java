package com.cybertek.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P6_HeaderVerification {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://zero.webappsecurity.com/login.html");

        //verify header text
        //1-get the header
        WebElement header= driver.findElement(By.tagName("h3")); //assign it tp web element in order to return it as a web element

        String actualText= driver.findElement(By.tagName("h3")).getText();//find element returns a web element but when you add a get text it returns string
        String expectedText= "Log in to ZeroBank";

         //2-verify the header
        if (actualText.contains(expectedText)) {
            System.out.println("passed");
        }else{
            System.out.println("failed");

        }
    }
}
