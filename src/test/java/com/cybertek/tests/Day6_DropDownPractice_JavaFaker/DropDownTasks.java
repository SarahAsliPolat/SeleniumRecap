package com.cybertek.tests.Day6_DropDownPractice_JavaFaker;

import com.cybertek.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDownTasks {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){

         driver= WebDriverFactory.getDriver("chrome");
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @Test
    public void test2() throws InterruptedException{
        //verify state dropdown
        Select stateDropdown=new Select(driver.findElement(By.xpath("//select[@id='state']")));
        //select illinois
        Thread.sleep(2000);
        stateDropdown.selectByVisibleText("Illinois");

        Thread.sleep(2000);
        //select virginia
        stateDropdown.selectByValue("VA");

        Thread.sleep(2000);
        //select california
        stateDropdown.selectByIndex(5);

        String expectedResult="California";
        String  actualResult=stateDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualResult,expectedResult,"actual and expected results aren't equal");

        //
    }

    @Test
    public void test3_date_dropdown_verification() throws InterruptedException{
        //selecting date on dropdown and verifying handled in before method
        //locate dropdown
        Select yearDropdown =new Select(driver.findElement(By.xpath("//select[@id='year']")));
        Select monthDropdown =new Select(driver.findElement(By.xpath("//select[@id='month']")));
        Select dayDropdown =new Select(driver.findElement(By.xpath("//select[@id='day']")));

        Thread.sleep(3000);
        //create expected values in one place
        String expectedYear="1983";
        String expectedMonth="April";
        String expectedDay="9";

        Thread.sleep(2000);
        //verify the date is selected
        yearDropdown.selectByVisibleText("1983");
        monthDropdown.selectByValue("3");
        dayDropdown.selectByIndex(8);


        String actualYear =yearDropdown.getFirstSelectedOption().getText();
        String actualMonth= monthDropdown.getFirstSelectedOption().getText();
        String actualDay=dayDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualYear,expectedYear,"years aren't equal");
        Assert.assertEquals(actualMonth,expectedMonth,"months aren't equal");
        Assert.assertEquals(actualDay,expectedDay,"days aren't equal");

    }

    @Test
    public void test4_multiple_value_select_dropdown() throws InterruptedException{

        //select all options from multiple dropdown
        //locate the dropdown
        Select multipleSelectDropdown=new Select(driver.findElement(By.xpath("//select[@name='Languages']")));

         List<WebElement> allOptions= multipleSelectDropdown.getAllSelectedOptions();

       //loop through the options to select all of them
        for(WebElement eachOptions : allOptions){
            Thread.sleep(5000);
            eachOptions.click();//this will click each option with every iteration

            System.out.println("Selected: "+eachOptions.getText());

            Assert.assertTrue(eachOptions.isSelected(),"The option :"+eachOptions.getText()+" is not selected!");

            multipleSelectDropdown.deselectAll();

            for(WebElement eahOption: allOptions){
                Assert.assertTrue(!eachOptions.isSelected());
                Assert.assertFalse(eachOptions.isSelected());
            }
        }


    }

    @Test
    public void test5_html_dropdown_handling(){

        //locate the drop down as a regular web element

        WebElement webSiteDropdown= driver.findElement(By.id("dropdownMenuLink"));
        webSiteDropdown.click();

        WebElement facebookLink = driver.findElement(By.xpath("//a[.='Facebook']"));
        facebookLink.click();

        String actualTitle = driver.getTitle();
        String expectedTitle="Facebook - Log In or Sign Up" ;
        driver.close();

        Assert.assertEquals(actualTitle,expectedTitle,"title verification is Failed!");
    }
}
