package com.cybertek.tests.day10_testbase_properties_driverUtil;

import com.cybertek.Utilities.SmartBearUtilities;
import com.cybertek.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class SmartBearPractices_9_10_11 {

    WebDriver driver;

    @BeforeMethod

        public void setupMethod(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        SmartBearUtilities.loginToSmartBear(driver);

        }
        @Test
        public void p9_delete_order_task() throws IOException {
            Properties properties=new Properties();//creating properties object to be able to read properties file
            FileInputStream file = new FileInputStream("configuration.properties");
            properties.load(file);//loading the file into properties object
            String url= properties.getProperty("smartbearUrl");


        //locate the checkbox for Mark Smith and click to it
            WebElement markSmith = driver.findElement(By.xpath("//td[.='Mark Smith']/../td[1]"));
            markSmith.click();
            //locate delete selected button and click
            WebElement deleteButton=driver.findElement(By.id("ctl00_MainContent_btnDelete"));
            deleteButton.click();

//we will create a loop to loop through alol the names so we can assert Mark Smith is not in the list anymore
            List<WebElement> namesList =driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[2]"));

            for (WebElement each : namesList) {
                Assert.assertFalse(each.getText().equals("Mark Smith"));


            }

        }
    }


