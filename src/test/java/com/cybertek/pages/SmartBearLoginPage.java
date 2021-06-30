package com.cybertek.pages;

import com.cybertek.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SmartBearLoginPage {
    /*
    we store all the web elements and methods related to LoginPage in this class
     */

    public SmartBearLoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);//we call inielement-initilizeelement-method from pagefactory class and it creates a connection between our driver and object of the class means the current object.so whenever we call the constructor to reach nythingit will call the construvtor and initiliaze the driver with obj of the class so that the driver knows where to go and how to find the web elements
    }


    @FindBy(id="ctl00_MainContent_username")
    public static WebElement usernameInput;

    @FindBy(id="ctl00_MainContent_password")
    public static WebElement passwordInput;

    @FindBy(id="ctl00_MainContent_login_button")
    public static WebElement loginButton;

    @FindBy(id="ctl00_MainContent_status")
    public static WebElement errorMessage;

    public static void login(String username , String password){
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }
}