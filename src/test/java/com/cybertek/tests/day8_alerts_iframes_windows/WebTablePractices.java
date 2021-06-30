package com.cybertek.tests.day8_alerts_iframes_windows;

import com.cybertek.Utilities.SmartBearUtilities;
import com.cybertek.Utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WebTablePractices {

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
    public void task4_verify_order(){
        SmartBearUtilities.verifyOrder(driver,"Mark Smith");
       // SmartBearUtilities.verifyOrder(driver,"Asli");assertion error:name doesn't exist
    }

    @Test
    public void task5_print_names_and_cities(){
        SmartBearUtilities.printNamesAndCities(driver);

    }
}
