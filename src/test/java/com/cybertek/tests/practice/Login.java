package com.cybertek.tests.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login {


    WebDriver driver;

    @BeforeMethod

    public void setup() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://hr-testing.buffsci.org/");
        driver.manage().window().maximize();
        Thread.sleep(3000);

    }

    @Test
    public void user_clicks_on_login_button() {
        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();

    }

    @Test
    public void user_logs_in() {
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@staging-buffsci.org");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("admin123test",Keys.ENTER);
}}