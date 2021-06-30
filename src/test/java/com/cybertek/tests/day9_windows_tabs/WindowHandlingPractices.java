package com.cybertek.tests.day9_windows_tabs;

import com.cybertek.Utilities.BrowserUtils;
import com.cybertek.Utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowHandlingPractices {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod()  {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/windows");
    }

    @Test
    public void practice5_window_handling_practices(){
        String actualTitle= driver.getTitle();
        System.out.println("actualTitle = " + actualTitle);

        Assert.assertTrue(actualTitle.equals("Practice"));
        WebElement clickHereLink=driver.findElement(By.linkText("Click Here"));
        BrowserUtils.wait(2);
        clickHereLink.click();

        String titleAfterClick=driver.getTitle();
        System.out.println("titleAfterClick = " + titleAfterClick);

       String mainHandle= driver.getWindowHandle();
        System.out.println("mainHandle = " + mainHandle);

       Set<String> WindowHandles= driver.getWindowHandles();
        //System.out.println("WindowHandles = " + WindowHandles);
//we loop through the set of window window handles so that we can get the window handle of the other windows
        //than using swichTo() method we switch to the other windows
        for (String each : WindowHandles) {
            driver.switchTo().window(each);
            System.out.println("The current title: "+driver.getTitle());
        }

        Assert.assertTrue(driver.getTitle().equals("New Window"));

        driver.switchTo().window(mainHandle);//to switch back to main page to continue with some other actions

        driver.quit();//it will close all of the tabs vs driver.close closes only current tab


    }

    @Test
    public void practice6_handling_more_than_two_windows(){

        driver.get("https://amazon.com");

        //WE ARE DOWNCASTING OUR DRIVER TYPE TP JAVASCRIPTEXECUTER
        //THE ONLY THING THIS LINE IS DOING IS USING JAVASCRIPT EXECUTER->OPENNING NEW TABS WITH GIVEN LINKS
        ((JavascriptExecutor) driver).executeScript(("window.open('http://google.com','_blank');"));
        ((JavascriptExecutor) driver).executeScript(("window.open('http://etsy.com','_blank');"));
        ((JavascriptExecutor) driver).executeScript(("window.open('http://facebook.com','_blank');"));


        //loop through and store each of the titles
        Set<String> windowHandles = driver.getWindowHandles();
        for (String each : windowHandles) {
            driver.switchTo().window(each);
            System.out.println("Current Page Title = " + driver.getTitle());

//this if condition determines where our driver to stop. if you wqant to work on something on etsy than you have the below if condition
            if (driver.getCurrentUrl().contains("etsy")) {
                Assert.assertTrue(driver.getTitle().contains("Etsy"));
                break;//we want to stop at etsy not go further
            }
        }

    }


}
