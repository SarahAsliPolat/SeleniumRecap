package com.cybertek.tests.day10_testbase_properties_driverUtil;

import com.cybertek.Utilities.BrowserUtils;
import com.cybertek.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionsPractices {

    @Test
    public void hover_over_test(){

        Driver.getDriver().get("http://practice.cybertekschool.com/hovers");

        WebElement image1= Driver.getDriver().findElement(By.xpath("(//div[@class='figure'])[1]"));
        WebElement image2= Driver.getDriver().findElement(By.xpath("(//div[@class='figure'])[2]"));
        WebElement image3= Driver.getDriver().findElement(By.xpath("(//div[@class='figure'])[3]"));

        WebElement user1= Driver.getDriver().findElement(By.xpath("//h5[.='name: user1']"));
        WebElement user2= Driver.getDriver().findElement(By.xpath("//h5[.='name: user2']"));
        WebElement user3= Driver.getDriver().findElement(By.xpath("//h5[.='name: user3']"));

        //create the instance of actions class, and pass the driver instance into the constructor
        Actions actions =new Actions(Driver.getDriver());

        //use the actions obj , and call necessary methods
        BrowserUtils.wait(2);
        actions.moveToElement(image1).perform();
        Assert.assertTrue(user1.isDisplayed(),"user 1 is not displayed. test failed");

        Actions actions1=new Actions(Driver.getDriver());
        actions1.moveToElement(image2).perform();
        Assert.assertTrue(user2.isDisplayed());

        Actions actions2=new Actions(Driver.getDriver());
        actions2.moveToElement(image3).perform();
        Assert.assertTrue(user3.isDisplayed());



    }
}
