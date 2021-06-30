package com.cybertek.tests.day4_FindElements_Checkboxes_Radio;

import com.cybertek.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P2_MerriamWebster_Links {
    public static void main(String[] args) {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.merriam-webster.com");

        List<WebElement> listOfLinks = driver.findElements(By.xpath("//body//a"));

        int linkWithoutText=0;
        int linksWithText=0;

        for(WebElement eachOfLinks: listOfLinks) {
            String textOfEachLink = eachOfLinks.getText();
            System.out.println(textOfEachLink);

            if (textOfEachLink.isEmpty()) {
                linkWithoutText++;
            } else {
                linksWithText++;
            }
        }
            System.out.println("linksWithText = " + linksWithText);
            System.out.println("linkWithoutText = " + linkWithoutText);



        for(WebElement eachLink: listOfLinks) {
            System.out.println("eachLink = " + eachLink.getText());
        }
            int numberOfLinks=listOfLinks.size();
        System.out.println("numberOfLinks = " + numberOfLinks);


        }

    }

