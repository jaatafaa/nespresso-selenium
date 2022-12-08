package com.nespresso.selenium.testing.testclasses;

import com.nespresso.selenium.testing.pageobjects.HomePage;
import com.nespresso.selenium.testing.pageobjects.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LoginPageTest extends BaseClass {

    @Test
    public void loginTest() throws IOException, InterruptedException {
        driver.get(baseUrl);
        driver.manage().window().maximize();
        logger.info("Base url "+ baseUrl + " opened");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        HomePage homePage = new HomePage(driver);
        homePage.clickAcceptButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginButton();

        WebElement elem = driver.findElement(By.xpath("//*[text()='SE CONNECTER']"));

        Actions act = new Actions(driver);
        act.release(elem).build().perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='SE CONNECTER']")));

        loginPage.setUsername(username);
        logger.info("The username "+ username + " is entered");

        loginPage.setPassword(password);
        logger.info("The password "+ password + " is entered");

        loginPage.clickRememberMeCheckBox();
        loginPage.clickSubmit();
        captureScreenshot(driver, "Login Action Test");
    }
}
