package com.cybertek.tests.day5_TestNG_Intro;

import com.cybertek.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestNG_Practices {
    WebDriver driver;//instance method in order to be able call drive in the class
    @BeforeMethod
    public void SetUpMethod(){
         driver= WebDriverFactory.getDriver("chrome");
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
         driver.get("https://www.google.com");//repeated steps can be in before method..
    }
    @Test
    public void googleVerification(){
        System.out.println("Google Title Verification Test is Running...");
        //go to google and verify the title is google
        String expectedTite="Google";
        String actualTitle= driver.getTitle();

        Assert.assertEquals(actualTitle,expectedTite,"titles are not matching");//if assertion fails it will stop executing the code
    }

    @Test
    public void google_search_title_verification(){
        System.out.println("Google Search Title Verification Test is Running...");

        //go to google-->this step will be taken care of in the before method
        //type apple
        WebElement searchBox=driver.findElement(By.name("q"));
        searchBox.sendKeys("Apple"+ Keys.ENTER);

        //make sure title contains apple
        String expectedTitle="Apple";
        String actualTitle= driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitle),"Title doesn't contain search value");
    }


    @AfterMethod
    public void tearDownMethod() throws InterruptedException{
        Thread.sleep(3000);
        driver.close();

    }

}
