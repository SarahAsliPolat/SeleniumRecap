package com.cybertek.tests.day3_cssSelector_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P2_ZeroBankVerification {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.get("http://zero.webappsecurity.com/login.html");
        driver.manage().window().maximize();

        WebElement zeroBankLinkTopLeft= driver.findElement(By.className("brand"));

        String expectedLinkText="Zero Bank";
        String actualLinkText=zeroBankLinkTopLeft.getText();

        if(actualLinkText.equals(expectedLinkText)) {
            System.out.println("link text verification test passed");
        }else{
            System.out.println("link text verification test failed");
        }

        //verify link href attribute value contains: expected"index.html"
        String expectedHref="index.html";
        String actualHref= zeroBankLinkTopLeft.getAttribute("href");

        if (actualHref.contains(expectedHref)) {
            System.out.println("Href value verification passed");
        }else{
            System.out.println("Href value verification failed");
        }

    }
}
