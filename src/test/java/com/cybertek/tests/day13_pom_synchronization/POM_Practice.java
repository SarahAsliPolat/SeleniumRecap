package com.cybertek.tests.day13_pom_synchronization;

import com.cybertek.pages.SmartBearLoginPage;
import org.testng.annotations.Test;

public class POM_Practice {

    SmartBearLoginPage loginPage;

    @Test
            public void login_to_smartbear() {
        SmartBearLoginPage loginPage = new SmartBearLoginPage();
        SmartBearLoginPage.usernameInput.sendKeys("tester");

    }

    }





