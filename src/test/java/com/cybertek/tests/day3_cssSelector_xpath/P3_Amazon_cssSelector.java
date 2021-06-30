package com.cybertek.tests.day3_cssSelector_xpath;

import com.cybertek.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P3_Amazon_cssSelector {
    public static void main(String[] args) {

        /*
        open chrome browser
        go to amazon.com ,

        verify title contains search term
         */

        WebDriver driver= WebDriverFactory.getDriver("Chrome");
        driver.get("https://amazon.com");
        driver.manage().window().maximize();

        //  enter search term (use cssSelector to locate search box
        WebElement searchBox= driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']"));
        searchBox.sendKeys("wooden toys"+ Keys.ENTER);

        String  actualSearchBox= driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']")).getAttribute("id");
        String expectedSearchBox="twotabsearchtextbox";


        if (actualSearchBox.equals(expectedSearchBox)) {
            System.out.println("test passed");
        }else{
            System.out.println("test failed");
        }

        }



    }

