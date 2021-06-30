package com.cybertek.tests.day13_pom_synchronization;

import com.cybertek.Utilities.ConfigurationReader;
import com.cybertek.Utilities.Driver;
import com.cybertek.pages.SmartBearLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigateLoginTests_SB {


    @Test (description = "entering incorrect username")
    public void negative_login_test1(){

        String url= ConfigurationReader.getProperty("smartbearUrl");
        Driver.getDriver().get(url);

        //1-we neeed to create the object of the class we want to use
        SmartBearLoginPage loginPage =new SmartBearLoginPage();
        //when we create the instance of this class, the constructor immediately initializes our driver and the object loginPage

        //2-call the object to use the web elements
        SmartBearLoginPage.usernameInput.sendKeys("Testers");

        String password= ConfigurationReader.getProperty("smartbear_password");
        SmartBearLoginPage.passwordInput.sendKeys(password);

        SmartBearLoginPage.loginButton.click();

        Assert.assertTrue(SmartBearLoginPage.errorMessage.isDisplayed(),"Error msg isn't displayed");


    }

    @Test(description = "using login method for negative test")
    public void negative_login2(){
        String url=ConfigurationReader.getProperty("smartbearUrl");
        Driver.getDriver().get(url);

        SmartBearLoginPage loginPage =new SmartBearLoginPage();

        String username = "cokuykumvar";
        String password = ConfigurationReader.getProperty("smartbear_password");

        SmartBearLoginPage.login(username,password);

    }

}
