package com.cybertek.Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
    /*
    NEW METHOD CREATION:
    Method name: getDriver
    Static method
    Accepts string argument : browser type->will determine what browser opens
    return type:WebDriver
     */

    public static WebDriver getDriver(String browserType){
        if(browserType.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }else if(browserType.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }else{
            System.out.println("Given driver does not exist. Driver=null!");
            return null;

        }

    }


    }
