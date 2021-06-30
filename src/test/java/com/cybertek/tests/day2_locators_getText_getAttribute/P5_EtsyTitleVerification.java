package com.cybertek.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P5_EtsyTitleVerification {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.get("https://Etsy.com");

       String Title= driver.getTitle();
        System.out.println(Title);

        driver.findElement(By.id("global-enhancements-search-query")).sendKeys("Wooden Spoon"+ Keys.ENTER);
         driver.findElement(By.tagName("div"));



    }
}
