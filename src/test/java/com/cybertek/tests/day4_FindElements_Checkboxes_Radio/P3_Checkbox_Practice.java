package com.cybertek.tests.day4_FindElements_Checkboxes_Radio;

import com.cybertek.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P3_Checkbox_Practice {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/checkboxes");
        driver.manage().window().maximize();

        //locating check boxes:
        WebElement checkBox1=driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));

        WebElement checkBox2= driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));

        //confirm checkbox number1 is not selected=
        if(!checkBox1.isSelected()) {
            System.out.println("checkbox is not selected. verification passed");
        }else{
            System.out.println("checkbox is selected. verification failed");
        }

        //checkbox number 2=>selected
        if(checkBox2.isSelected()) {
            System.out.println("checkbox is selected. verification passed");
        }else{
            System.out.println("checkbox is not selected. verification not passed");
        }
        System.out.println("=============================================================");

        //click checkbox1 to select it
        checkBox1.click();

        //click checkbox2 to deselect it
        checkBox2.click();

        if(checkBox1.isSelected()) {
            System.out.println("checkbox is selected. verification passed");
        }else{
            System.out.println("checkbox is not selected. verification failed");
        }
        if(!checkBox2.isSelected()) {
            System.out.println("checkbox is not selected. verification passed");
        }else{
            System.out.println("checkbox is selected. verification not passed");
        }
        //THIS WILL CREATE STALE ELEMENT REFERENCE EXCEPTION
        WebElement homeLink = driver.findElement((By.xpath("//a[.='Home']")));
        homeLink.click();

        Thread.sleep(1000);
        driver.navigate().back();

        Thread.sleep(1000);
        //TO SOLVE I NED TO REFRESH THE ELEMENT REFERENCE MEANS RELOCATING THE ELEMENT REFERENCE
        checkBox1=driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));//COPY PASTE THE ELEMENT REFERENCE FROM ABOVE TO REFRESH IT IN ORDER TO HANDLE THE EXCEPTION

        checkBox1.click();

    }
}
