package com.cybertek.tests.day3_cssSelector_xpath;

import com.cybertek.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P4_PracticeCybertekSchool {
    public static void main(String[] args) {

      WebDriver driver= WebDriverFactory.getDriver("chrome");
      driver.get("http://practice.cybertekschool.com/multiple_buttons");

        WebElement button2 = driver.findElement(By.xpath("//button[@name='button2']"));
        button2.click();

        String actualButton =driver.findElement(By.xpath("//button[@name='button2']")).getAttribute("name");
        String expectedButton="button2";

        if(actualButton.equals(expectedButton)) {
            System.out.println("test passed");
        }else{
            System.out.println("test failed");
        }
    }
}
