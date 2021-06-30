package com.cybertek.tests.day8_alerts_iframes_windows;

import com.cybertek.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Iframe_Practice {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/iframe");
    }

    @Test
    public void p4_iframe_practice(){
       // WebElement myAlert= driver.findElement(By.id("mceu_31"));
       // Alert alert=driver.switchTo().alert();
       // alert.accept();
        //WebElement clickOk= driver.findElement(By.id("mceu_31"));
       // clickOk.click();

       // 3 ways to locating and switching to an iframe
        // 1-by index,
       // driver.switchTo().frame(0);

      //  2-id or name,passing id attribute value to locate the iframe
        driver.switchTo().frame("mce_0_ifr");

        // 3-locate as a web element, then switch to it
       // driver.switchTo().frame("mce_0_ifr");

        WebElement yourContentGoesHereText= driver.findElement(By.xpath("//p"));//you have to handle the ifram because the text is inside an iframe

        Assert.assertTrue(yourContentGoesHereText.isDisplayed());
        driver.switchTo().defaultContent();

        //Assert "An iframe containing the TinyMCE WYSIWYG Editor"
        WebElement headerText= driver.findElement(By.xpath("//h3[.='An iFrame containing the TinyMCE WYSIWYG Editor']"));//there is only one h3 so we used header for our xpath
    }
}