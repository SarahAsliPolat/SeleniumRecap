package com.cybertek.tests.Day6_DropDownPractice_JavaFaker;

import com.cybertek.Utilities.SmartBearUtilities;
import com.cybertek.Utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SmartBearTests {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        SmartBearUtilities.loginToSmartBear(driver);
    }


    @Test
    public void test1_Login_page_links_print_test(){
        //enter userName"Tester'

        //print account of all the links on landing page
       List<WebElement> allLinks=  driver.findElements(By.xpath("//body//a"));

        System.out.println("allLinks.size = " + allLinks.size());

        //print each link text on this page

        for(WebElement eachLink: allLinks){
            System.out.println("eachLink = " + eachLink.getText());


        }

    }


    @Test
    public void test2_create_order_with_java_faker() throws InterruptedException{
        //click on order button
        WebElement orderButton=driver.findElement(By.xpath("//a[.='Order']"));
        orderButton.click();

        //select family album product
        Select productDropdown=new Select(driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct")));
        productDropdown.selectByValue("FamilyAlbum");
       // /set quantity to 2

        WebElement quantityInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity"));

        quantityInput.sendKeys(Keys.BACK_SPACE);
        Thread.sleep(3000);
        quantityInput.sendKeys("2");

        //.click calculate button
        WebElement calculateButton= driver.findElement(By.xpath("//input[@value='Calculate']"));



        //locating all of the elements
        WebElement nameBox=driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName"));
        WebElement street =driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2"));
        WebElement city= driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3"));
        WebElement state= driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4"));
        WebElement zipCode= driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5"));

        //fill info with java faker: generate name, street , city, state, zip code

        Faker faker=new Faker();
        nameBox.sendKeys(faker.name().fullName());
        street.sendKeys(faker.address().streetAddress());
        city.sendKeys(faker.address().city());
        state.sendKeys(faker.address().state());
        zipCode.sendKeys(faker.address().zipCode().replaceAll("-",""));

        //click on "visa" radio button
        WebElement visaRadioButton=driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0"));
        visaRadioButton.click();

        //generate card number with java faker
        WebElement creditCardInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6"));
        creditCardInput.sendKeys(faker.finance().creditCard().replaceAll("-",""));

        //enter expr date
        WebElement expDate= driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1"));
        expDate.sendKeys("12/25");


        //click on process
        WebElement processButton = driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton"));
        processButton.click();

        //verify the success msg
       WebElement successMsg= driver.findElement(By.xpath("//strong"));
        Assert.assertTrue(successMsg.isDisplayed());



    }

}
