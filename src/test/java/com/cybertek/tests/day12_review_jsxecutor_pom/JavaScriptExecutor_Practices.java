package com.cybertek.tests.day12_review_jsxecutor_pom;

import com.cybertek.Utilities.BrowserUtils;
import com.cybertek.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JavaScriptExecutor_Practices {

    @Test
    public void scrolling_using_JavaScriptExecutor() {

        Driver.getDriver().get("http://practice.cybertekschool.com/infinite_scroll");

        //create instance of JSExecutor and cast our driver type to it
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        //use execute.script method

        for (int i = 0; i < 10; i++) { //page will scroll by 230 10 times
            BrowserUtils.wait(2);
            js.executeScript("window.scrollBy(0,230)");

        }
    }
        @Test//different types of scroll

        public void scroll_using_jsexecutor_2(){
            Driver.getDriver().get("http://practice.cybertekschool.com/large");//get the page to scroll

            //use js executor to scroll 'Cybertek School' link intoView
            JavascriptExecutor js= (JavascriptExecutor)Driver.getDriver();

            //locating cybertek school link
            BrowserUtils.wait(2);
           WebElement link= Driver.getDriver().findElement(By.linkText("Cybertek School"));//below we gave an amount for scrolling, with this method , we located where we want to scroll which is cybertek school link

             WebElement homeLink = Driver.getDriver().findElement(By.linkText("Home"));

             BrowserUtils.wait(2);
            //use scrollIntoView function from JavaScript to scroll to a specific web element
            js.executeScript("arguments[0].scrollIntoView(true)",link);//we use scrollIntoView function for the first part of the arg and the second part is the link down in the page and we located it below
            //the code below is a javascript code. we say scroll in to view/get the first argument
            BrowserUtils.wait(2);

            js.executeScript("arguments[0].scrollIntoView(true)", homeLink);






    }

}
