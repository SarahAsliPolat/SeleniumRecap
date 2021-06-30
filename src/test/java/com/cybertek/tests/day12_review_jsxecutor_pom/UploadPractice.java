package com.cybertek.tests.day12_review_jsxecutor_pom;

import com.cybertek.Utilities.BrowserUtils;
import com.cybertek.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadPractice {

    @Test
    public void uploding_file_test() {
        Driver.getDriver().get(" http://practice.cybertekschool.com/upload");
        Driver.getDriver().manage().window().maximize();

        String path = " C:\\Users\\sarah\\Downloads\\PHOTO-2020-11-21-20-36-42.jpg";

//locate the upload web element
        WebElement uploadInput = Driver.getDriver().findElement(By.id("file-upload"));

        uploadInput.sendKeys(path);

        //locate the upload button
        WebElement uploadButton = Driver.getDriver().findElement(By.id("file-submit"));
        BrowserUtils.wait(2);
        uploadButton.click();

        WebElement verificationMsg = Driver.getDriver().findElement(By.xpath("//h3[.='File Uploaded!']"));
        Assert.assertTrue(verificationMsg.isDisplayed());
    }
        @Test
                public void upload_picture(){

        Driver.getDriver().get("http://practice.cybertekschool.com/upload");
        Driver.getDriver().manage().window().maximize();

        String path2 = "C:\\Desktop\\gurhan.png";

        WebElement uploadButton =Driver.getDriver().findElement(By.id("file-submit"));
        BrowserUtils.wait(2);
        uploadButton.click();





    }


}
