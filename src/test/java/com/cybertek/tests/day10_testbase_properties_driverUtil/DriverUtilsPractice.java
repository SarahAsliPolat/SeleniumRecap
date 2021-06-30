package com.cybertek.tests.day10_testbase_properties_driverUtil;
import com.cybertek.Utilities.ConfigurationReader;
import com.cybertek.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
public class DriverUtilsPractice {

    @Test
    public void simple_google_search_test(){

        Driver.getDriver().get("https://google.com");//first Driver is the class we created so we are able to call the getDriver method that shortens the code that we need to write
        WebElement searchBox=Driver.getDriver().findElement(By.name("q"));
        String search = ConfigurationReader.getProperty("searchValue");

        searchBox.sendKeys("Selenium certificate"+ Keys.ENTER);

        String expectedTitle ="Selenium";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitle));



    }
}
