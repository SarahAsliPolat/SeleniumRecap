package com.cybertek.tests.practice;

import com.cybertek.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class etsy {

    WebDriver driver;

        @BeforeMethod
            public void setUpMethod() throws InterruptedException {
            driver = WebDriverFactory.getDriver("chrome");
            driver.manage().window().maximize();
            driver.get("https://www.etsy.com");

        }
            @Test
            public void etsySearch() throws InterruptedException {

            WebElement searchbar = (WebElement) driver.findElement(By.name("search_query"));
            searchbar.click();
            Thread.sleep(500);
            searchbar.sendKeys("spoon"+ Keys.ENTER);


        }

        @Test
    public void menubar() throws InterruptedException {


            WebElement menubar = driver.findElement(By.xpath("//span[@class='wt-display-table-cell wt-text-left-xs']"));
            menubar.click();

            Actions action = new Actions(driver);
            List<WebElement> menubars= driver.findElements(By.xpath("//ul[@role='menubar']//li"));
            for (WebElement menubar2:menubars) {
                action.moveToElement(menubar2).perform();
                Thread.sleep(500);

            }


        }


        }





