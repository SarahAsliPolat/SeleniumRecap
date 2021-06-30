package com.cybertek.tests.day8_alerts_iframes_windows;

import com.cybertek.Utilities.BrowserUtils;
import com.cybertek.Utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AlertPractices {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod()  {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
    }
    @Test
    public void p1_information_alert_practice(){
        WebElement warningAlertButton= driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        BrowserUtils.wait(2);
        warningAlertButton.click();

        //create alert instance and switch to alert
        Alert alert=driver.switchTo().alert();
        BrowserUtils.wait(2);
        alert.accept(); //you can only accept

        //locate the success msg
        WebElement successMsg= driver.findElement(By.xpath("//p[@id='result']"));

        Assert.assertTrue(successMsg.isDisplayed(),"Test PASSED SUCCESSFULLY");


    }
    @Test
    public void p2_confirmation_alert_practice(){

        WebElement warningAlertButton= driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        warningAlertButton.click();

        Alert alert =driver.switchTo().alert();

        //you can accept or dismiss
       // alert.dismiss();
         alert.accept();

         WebElement resultText= driver.findElement(By.xpath("//p[.='You clicked: Ok']"));
         Assert.assertTrue(resultText.isDisplayed());

    }

    @Test
    public void pageSource(){
        driver.get("https://www.google.com");
        String pageSource = driver.getPageSource();
        System.out.println("page source"+ pageSource);

    }

}