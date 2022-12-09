package com.nespresso.selenium.testing.testclasses;

import com.nespresso.selenium.testing.pageobjects.HomePage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class ValidationPanierTest extends BaseClass {

    @Test
    public void validationPanierTest() throws IOException {
        driver.get(baseUrl);
        logger.info("Base url "+ baseUrl + " opened");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));

        HomePage homePage = new HomePage(driver);
        waitForNSeconds(1);

        homePage.clickAcceptButton();
        waitForNSeconds(1);

        homePage.clickNespressoProfessionnelLink();
        waitForNSeconds(1);

        homePage.clickFirstAcheterButtonTexts();
        waitForNSeconds(1);

        boolean isBannerDisplayed = driver.findElements(By.id("_evidon-banner-content")).size() < 1;
        captureScreenshot(driver, "Home Page - Banner button accept");
        assertTrue(isBannerDisplayed);

        driver.get("https://www.nespresso.com/pro/fr/fr/order/machines/pro");
        waitForNSeconds(4);
        driver.get("https://www.nespresso.com/pro/fr/fr/order/machines/pro/machine-cafe-professionnelle-pack-zenius");
        waitForNSeconds(1);

        captureScreenshot(driver, "Validation Panier Test");
        driver.findElement(By.id("ta-product-details__add-to-bag-button")).click();
        waitForNSeconds(1);

        assertTrue(driver.findElement(By.xpath("//*[text()='Pack Zenius']")).isDisplayed());
    }
}
