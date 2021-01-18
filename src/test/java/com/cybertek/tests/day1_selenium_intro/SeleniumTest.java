package com.cybertek.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    public static void main(String[] args) throws InterruptedException{

        //setup the driver
        WebDriverManager.chromedriver().setup();

        //create instance of the driver
        WebDriver driver= new ChromeDriver();//

        //use the driver instance to test selenium
        driver.get("https://www.Google.com");
        driver.get("https://www.linkedIn.com");
        System.out.println("the title of this page is: "+driver.getTitle());

        String actualTitle= driver.getTitle();
        System.out.println("the title of this page is: "+ actualTitle);

        String actualUrl= driver.getCurrentUrl();
        System.out.println("The url of this page is: "+actualUrl);
        System.out.println("actualUrl = " + actualUrl);
        //actualTitle.soutv is the shortcut to write the print statement

        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().forward();
        Thread.sleep(3000);
        driver.navigate().refresh();
        Thread.sleep(3000);
        driver.navigate().to("https://www.sabah.com.tr");
        String pageSource=  driver.getPageSource();
        System.out.println("pageSource = " + pageSource);

        driver.manage().window().maximize();


    }
}
