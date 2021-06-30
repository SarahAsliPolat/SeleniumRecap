package com.cybertek.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P1_GoogleTitleVerification {
    public static void main(String[] args) {


        //task1-google title verification

        //step1- open chrome browser
        WebDriverManager.chromedriver().setup();

        //step2- go to the browser
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.Google.com");
        driver.manage().window().maximize();

        //step3- verify title (expected: Google)
        String expectedTitle= "Google";
        String actualTitle= driver.getTitle();

        if(actualTitle.equals(expectedTitle)) {
            System.out.println("test passed");
        }else{
            System.out.println("test failed");

        }
    }
}
