package com.cybertek.tests.practice;

import com.cybertek.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class drag_and_drop {
    WebDriver driver;

    @BeforeMethod

    public void setUpMethod(){

        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

    }

    @Test
    public void CapitolsAndCountries(){
        WebElement oslo = driver.findElement(By.id("box1"));
        WebElement washington = driver.findElement(By.id("box3"));
        WebElement cophengan = driver.findElement(By.id("box4"));
        WebElement madrid = driver.findElement(By.id("box7"));
        WebElement stolkhom= driver.findElement(By.id("box2"));
        WebElement rome = driver.findElement(By.id("box6"));
        WebElement seoul= driver.findElement(By.id("box5"));

        //mach the countries and capitols

        WebElement italy = driver.findElement(By.id("box106"));
        WebElement spain = driver.findElement(By.id("box107"));
        WebElement norway = driver.findElement(By.id("box101"));
        WebElement denmark= driver.findElement(By.id("box104"));
        WebElement southKorea= driver.findElement(By.id("box105"));
        WebElement sweden= driver.findElement(By.id("box102"));
        WebElement USA = driver.findElement(By.id("box103"));

        Actions actions =new Actions(driver);
        actions.dragAndDrop(rome,italy).build().perform();
        actions.dragAndDrop(washington,USA).build().perform();
        actions.dragAndDrop(oslo,norway).build().perform();
        actions.dragAndDrop(cophengan,denmark).build().perform();
        actions.dragAndDrop(madrid,spain).build().perform();
        actions.dragAndDrop(stolkhom,sweden).build().perform();
        actions.dragAndDrop(seoul,southKorea).build().perform();



    }
}
