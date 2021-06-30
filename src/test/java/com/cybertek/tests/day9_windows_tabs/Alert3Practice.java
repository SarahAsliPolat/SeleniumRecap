package com.cybertek.tests.day9_windows_tabs;

import com.cybertek.Utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Alert3Practice {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod()  {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
    }
    @Test
    public void p3_prompt_alert_practice(){
        WebElement promptAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));

        promptAlertButton.click();

        //using alert class to handle alert
        Alert alert =driver.switchTo().alert();
        String input="You entered: Selenium Recap";
        alert.sendKeys(input);
        alert.accept();

        WebElement resultText = driver.findElement(By.id("result"));
        Assert.assertTrue(resultText.isDisplayed(),"Text is not displayed. Test Failed!!");

        //verify that the result text contains the input

        String actual= resultText.getText();
        Assert.assertTrue(actual.contains(input));

    }
}
