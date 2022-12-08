package com.nespresso.selenium.testing.testclasses;

import com.nespresso.selenium.testing.pageobjects.LoginPage;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class LoginActionTest extends BaseClass {

    @Test
    public void loginTest() throws IOException {
        driver.get(baseUrl);
        logger.info("Base url "+ baseUrl + " opened");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername(username);
        logger.info("The username "+ username + " is entered");

        loginPage.setPassword(password);
        logger.info("The password "+ password + " is entered");
        loginPage.clickSubmit();

        captureScreenshot(driver, "Login Action Test");
        assertEquals(driver.getTitle(), "Guru99 Bank Manager HomePage");
    }
}
