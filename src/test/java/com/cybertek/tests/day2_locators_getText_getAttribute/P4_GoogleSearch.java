package com.cybertek.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P4_GoogleSearch {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.get("https://google.com");
       driver.findElement(By.name("q")).sendKeys("Selenium-Java certificate");
       Thread.sleep(3000);
       driver.findElement(By.name("btnK")).click();

       String actualTitle= driver.getTitle();
       String expectedTitle= "Selenium-Java";

       if(actualTitle.contains(expectedTitle)) {
           System.out.println("Title Test Passed");
       }else{
           System.out.println("Title Test Failed");
       }

    }
}
