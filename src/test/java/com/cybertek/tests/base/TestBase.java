package com.cybertek.tests.base;

import com.cybertek.Utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {//because we don't want to or anyone to be able to create an object from this class  and we just want to use it as a parent class and extend to sub classes we chose abstract class
//base is class to store all the methods that we use in every scenario
    protected WebDriver driver;//I want the class to be secure and also be able to extend by subclasses so chose it to be protected

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }


}
