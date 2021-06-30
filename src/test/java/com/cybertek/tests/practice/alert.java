package com.cybertek.tests.practice;

import com.cybertek.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class alert {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){

        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://demo.guru99.com/test/delete_customer.php");
    }

    @Test
    public void delete_costumer() throws InterruptedException {

        WebElement costumerID= driver.findElement(By.xpath("//input[@name='cusid']"));
        costumerID.sendKeys("futureSDET");

        WebElement submitButton = driver.findElement(By.xpath("//input[@name='submit']"));
        Thread.sleep(500);
        submitButton.click();

        Thread.sleep(500);
        driver.switchTo().alert().accept();

        Assert.assertEquals("Customer Successfully Delete!",driver.switchTo().alert().getText());
        Thread.sleep(600);
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
    }
}
