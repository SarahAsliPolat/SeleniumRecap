package com.cybertek.tests.day4_FindElements_Checkboxes_Radio;

import com.cybertek.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P1_Cybertek_ForgotPassword {
    public static void main(String[] args) {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //locate all th webelements on the page by using Xpath and CssSelector
       WebElement homeLink =driver.findElement(By.xpath("//a[.='Home']"));//using the text of the anchor tag to locate a

        //forgot password header
        WebElement forgotHeader =driver.findElement(By.xpath("//h2[.='Forgot Password']"));

        //"E-=mail" text
        WebElement emailLabel= driver.findElement(By.xpath("//label[@for='email']"));

        //email input box
        WebElement emailBox =driver.findElement(By.xpath("//input[@name='email']"));

        //retrieve password button
        WebElement retrievePasswordButton=driver.findElement(By.cssSelector("button#form_submit"));

        WebElement poweredByCybertek = driver.findElement(By.xpath("//div[@style='text-align: center;']"));
        WebElement linkText=driver.findElement(By.xpath("//a[.='Cybertek School']"));

        System.out.println("Link Text: "+linkText.getText());
        System.out.println("powered by Cybertek: "+ poweredByCybertek.getText());

        //verify all the WebElements above all displayed
        //is displayed returns a boolean value
        //PUTTING THEM ALL IN ONE LINE FOR VERIFICATION IF CONDITION; YOU CANNOT TELL WHICH ONE FAILED; IF ONE OF THEM FAILES ALL WILL BE FAILED; NOT READABLE

        if(homeLink.isDisplayed() && emailLabel.isDisplayed()&& emailBox.isDisplayed()&&retrievePasswordButton.isDisplayed()&&poweredByCybertek.isDisplayed() && forgotHeader.isDisplayed()) {
            System.out.println("ALL THE ELEMENTS ARE DISPLAYED. VERIFICATION PASSED!");
        }else {
            System.out.println("ONE OR MORE WEB ELEMENTS ARE NOT FOUND. VERIFICATION FAILED");

        }








    }
}
