package com.nespresso.selenium.testing.testclasses;

import com.nespresso.selenium.testing.pageobjects.HomePage;
import com.nespresso.selenium.testing.pageobjects.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginPageTest extends BaseClass {

    @Test
    public void loginTest() {
        driver.get(baseUrl);
        driver.manage().window().maximize();
        logger.info("Base url "+ getBaseUrl() + " opened");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        HomePage homePage = new HomePage(driver);
        waitForNSeconds(1);

        homePage.clickAcceptButton();
        waitForNSeconds(1);

        LoginPage loginPage = new LoginPage(driver);
        waitForNSeconds(1);

        loginPage.clickLoginButton();
        waitForNSeconds(1);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='CONNECTEZ-VOUS']")));

        loginPage.fillUserInfos(getUsername(), getPassword());
        waitForNSeconds(3);

        loginPage.clickLoginButton();
        waitForNSeconds(3);
    }
}
