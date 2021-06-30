package com.cybertek.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P2_CybertekURLVerification {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.gmail.com");
        driver.manage().window().maximize();

        String expectedInURL = "";
        String actualURL= driver.getCurrentUrl();
         if(actualURL.contains(expectedInURL)) {
             System.out.println("URL VERIFICATION TEST PASSED");
         }else{
             System.out.println("URL VERIFICATION TEST FAILED");
         }

        String expectedTitle ="Gmail";
        String actualTitle= driver.getTitle();
        if(actualTitle.contains(expectedTitle)) {
            System.out.println("TITLE VERIFICATION TEST PASSED");
        }else {
            System.out.println("TITLE VERIFICATION TEST FAILED");
        }
        }

    }

