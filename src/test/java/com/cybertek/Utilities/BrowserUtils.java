package com.cybertek.Utilities;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BrowserUtils {

    /*create a method accepts a list of web element
    @param List<WebElement>
    @return List<String>
    should return a list of String
     */
    public static List<String> getElementsText(List<WebElement> list){
        List<String> webElementAsString = new ArrayList<>();
        for(WebElement each: list){
            webElementAsString.add(each.getText());
        }
        return webElementAsString;
    }

    /*
    Create a utility method named: wait
    static method
    @param sec
    integer num that i pass as parameter should be accepted as SECONDS
    @return void
     */

    public static void wait(int sec){
        try {
            Thread.sleep(1000*sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("interrupted exception caught");
        }

    }
}
