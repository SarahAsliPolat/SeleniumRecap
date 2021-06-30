package com.cybertek.tests.practice;

import com.cybertek.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class alert_types {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver= WebDriverFactory.getDriver("chrome" );
        driver.manage().window().maximize();
        driver.get("http://demo.automationtesting.in/Alerts.html");
    }

    @Test
    public void handlingAlerts() throws InterruptedException {
//simple alert
        driver.findElement(By.cssSelector(".btn.btn-danger")).click();
        Thread.sleep(500);

       driver.switchTo().alert().accept();

       driver.findElement(By.xpath("(//a[@class='analystic'])[2]")).click();
       Thread.sleep(500);

       driver.findElement( By.cssSelector(".btn.btn-primary")).click();
       driver.switchTo().alert().accept();

       //alert that asks for an input

        driver.findElement(By.xpath("(//a[@class='analystic'])[3]")).click();
        Thread.sleep(500);

        driver.findElement(By.cssSelector(".btn.btn-info")).click();
        Thread.sleep(500);

        driver.switchTo().alert().sendKeys("soon to be a test engineer with 100+ salary");
        Thread.sleep(500);
        driver.switchTo().alert().accept();

        String message = driver.findElement(By.xpath("//p[@id='demo1']")).getText();
        System.out.println(message);


      /*  driver.findElement(By.cssSelector(".btn-primary")).click();
        Thread.sleep(500);

        driver.switchTo().alert().dismiss();

        Thread.sleep(500);

       // driver.findElement(By.xpath("(//a[@class='analystic'])[3]")).click();



      */

    }
}
