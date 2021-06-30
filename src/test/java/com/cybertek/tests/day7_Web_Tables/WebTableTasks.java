package com.cybertek.tests.day7_Web_Tables;

import com.cybertek.Utilities.SmartBearUtilities;
import com.cybertek.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WebTableTasks {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        SmartBearUtilities.loginToSmartBear(driver);

    }

    @Test
    public void p3_verify_susans_order_date(){
        WebElement susansDate= driver.findElement(By.xpath("//td[.='Susan McLaren']/following-sibling::td[3]"));
        System.out.println("susansDate = " + susansDate.getText());

        String expectedDate= "01/05/2010";
        String actualDate=susansDate.getText();

        Assert.assertEquals(actualDate,expectedDate,"The dates are not matching");

       // Assert.fail(); developers created this in order to intentionally fail the test to fix / develop something on it later
        //TODO:fix the locator ASAP// //intellij reminds you if you have something to do later





    }
}
