package com.cybertek.tests.day3_cssSelector_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WT_CybrtekLinkVerification {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/forgot_password");
        driver.manage().window().maximize();

        //enter any email into input box
       // driver.findElement(By.name("email")).sendKeys("anyemail@domain.com");
        WebElement emailInputBox =driver.findElement(By.name("email"));//this is more usable
        emailInputBox.sendKeys("anyemail@domain.com");

        Thread.sleep(2000);
        //click on retrieve button
        driver.findElement(By. id("form_submit")).click();

        //verify url contains: email sent
        String expectedInUrl = "email_sent";
        String actualUrl=driver.getCurrentUrl();

        if (actualUrl.contains(expectedInUrl)) {

            System.out.println("passed");
        }else{
            System.out.println("failed");
        }
        //verify the text
       WebElement confirmationMessage=  driver.findElement(By.name("confirmation_message"));

        String actualText = driver.findElement(By.name("confirmation_message")).getText();
        String expectedText ="Your e-mail's been sent!";

        //if verification test is failing compare the expected and actual values by printing them what is the difference/wrong
        System.out.println("actual text "+actualText);
        System.out.println("expected text "+expectedText);

        if(actualText.contains(expectedText)) {
            System.out.println("header text test passed");
        }else{
            System.out.println("header text value verification failed");
        }
        //verify if the element is displayed or not
        if(confirmationMessage.isDisplayed()) {
            System.out.println("verification test passed");
        }else{
            System.out.println("verification test failed");
        }

    }
}
