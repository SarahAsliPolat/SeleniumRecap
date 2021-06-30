package com.cybertek.tests.day5_TestNG_Intro;

import com.cybertek.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class P05_Selenium_Task1 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //locate success message and checkbox under 'single checkbox demo'
        WebElement successCheckBox=driver.findElement(By.xpath("//input[@id='isAgeSelected']"));

        //locate sucess message
        WebElement successMessage= driver.findElement(By.xpath("//div[@id='txtAge'] "));

        //verify -success - check box is checked " message is not displayed
        if(!successMessage.isDisplayed()) {
            System.out.println("message is not displayed. verification passed");
        }else{
            System.out.println("message is displayed. verification failed");
        }

        //click the check box under single checkbox demo section
        successCheckBox.click();

        //verify success check box is checked msg is displayed

        if(successCheckBox.isSelected() && successMessage.isDisplayed()) {
            System.out.println("message is displayed. verification passed");
        }else{
            System.out.println("message is not displayed. verification passed");
        }

        Thread.sleep(3000);
        driver.close();

    }
}
