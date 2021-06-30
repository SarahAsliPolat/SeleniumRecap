package com.cybertek.tests.day8_alerts_iframes_windows;

import com.cybertek.Utilities.BrowserUtils;
import com.cybertek.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDownPractices {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @Test
    public void p7_month_dropdown_default_value_test(){

        Select monthDropdown = new Select((driver.findElement(By.xpath("//select[@id='month']"))));
        //we will create a dynamic expected value because the value of month will change as the months pass by

        //expected
        String expectedValue= LocalDateTime.now().getMonth().name();
        //System.out.println("expected value: "+expectedValue);

        //actual
        String actualValue= monthDropdown.getFirstSelectedOption().getText();
        //System.out.println("actual value: "+actualValue);

        Assert.assertEquals(actualValue.toLowerCase(),expectedValue.toLowerCase());
        Assert.assertTrue(actualValue.equalsIgnoreCase(expectedValue));

        //TASK8->i should see all of 12 months
        //This line gets all of the options from the dropdown and store the value in a list
        List<WebElement> actualMonthOptions = monthDropdown.getOptions();

        //Creating a list of strings to store months
        List<String> expectedMonthOptions = Arrays.asList("January", "February", "March", "April", "May", "June", "July",
                "August","September","October", "November", "December");
       // System.out.println(expectedMonthOptions.size());


       // Create a new list of Strings called: actualMonthsTexts , and store the texts of web elements into this new list
//
      List<String> actualMonthsTexts = new ArrayList<>();
//
       for (WebElement each : actualMonthOptions) {
//
           actualMonthsTexts.add(each.getText());
       }

           Assert.assertEquals(actualMonthsTexts, expectedMonthOptions);
        BrowserUtils.wait(1000);


           System.out.println(Arrays.toString(new List[]{actualMonthsTexts}));
//
//
           //Passing List into assertions:
           //First it will check the size, then it will check the content
           //Assert.assertEquals(actualMonthsTexts,expectedMonthOptions);


       }}
