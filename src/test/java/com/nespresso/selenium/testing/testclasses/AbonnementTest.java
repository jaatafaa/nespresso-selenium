package com.nespresso.selenium.testing.testclasses;

import com.beust.ah.A;
import com.nespresso.selenium.testing.pageobjects.AbonnementPage;
import com.nespresso.selenium.testing.pageobjects.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AbonnementTest extends BaseClass {

    @Test
    public void AbonnementOnlineTest() throws IOException {
        driver.get("https://www.nespresso.com/pro/fr/fr/abonnement-professionnel");
        logger.info("Base url "+ baseUrl + " opened");

        HomePage homePage = new HomePage(driver);
        waitForNSeconds(1);

        homePage.clickAcceptButton();
        waitForNSeconds(5);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        AbonnementPage abonnementPage = new AbonnementPage(driver);
        boolean isBannerDisplayed = driver.findElements(By.className("g_h3")).size() > 0;
        captureScreenshot(driver, "Abonnement Page - Machine is present");
        assertTrue(isBannerDisplayed);
        WebElement elementAddMachineZenius =driver.findElement(By.xpath("//div[@class='actions']/button[2]"));
       // WebElement elementAddMachineZenius = driver.findElements(By.className("g_btnBuy")).get(2); //ul[@class='list']/li[2]
        WebElement elementNextStep = driver.findElements(By.className("g_btnBuy")).get(0);

        elementAddMachineZenius.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(elementNextStep));
        //WebElement nextStepButton = driver.findElement(By.xpath("//button[@class='g_btnBuy']//span[text()='Étape suivante']"));
        WebElement nextStepButton = driver.findElement(By.xpath("//button[@class='button']"));
        //a[@class='googleSignInBtn']//child::span[text()='Nespresso Momento']
        //span[text()='Sign up with Google']
        //div[contains(@class,'card')]//descendant::span
        //div[@class='caption']//span[@data-amplitude='R_pp']
        wait.until(ExpectedConditions.elementToBeClickable(nextStepButton));
        waitForNSeconds(5);
        nextStepButton.click();



        WebElement classSlider = driver.findElements(By.className("g_h3")).get(0);
        //wait.until(ExpectedConditions.textToBePresentInElement(classSlider, "Capsules requises"));

        WebElement elementAddCaps = driver.findElements(By.className("g_btnBuy")).get(1);
        elementAddCaps.click();
        waitForNSeconds(10);
       // WebElement isCardCapsDisplayed = driver.findElement(By.className("popover")) ;
        //assertTrue(isCardCapsDisplayed.isDisplayed());

        WebElement add300Caps = driver.findElements(By.className("quantity")).get(6);
        add300Caps.click();
        wait.until(ExpectedConditions.elementToBeClickable(elementNextStep));

        //elementAddCaps.click();
        WebElement addGoblet = driver.findElements(By.className("g_h3")).get(3);
        wait.until(ExpectedConditions.elementToBeClickable(addGoblet));
        addGoblet.click();
        wait.until(ExpectedConditions.elementToBeClickable(elementNextStep));

        WebElement gotToPayment = driver.findElements(By.className("g_btnBuy")).get(0);
        waitForNSeconds(10);
        wait.until(ExpectedConditions.elementToBeClickable(gotToPayment));


        WebElement checkout = driver.findElement(By.className("checkout"));
        wait.until(ExpectedConditions.elementToBeClickable(checkout));
        checkout.click();
        // homePage.addToBagButton();
        //waitForNSeconds(1);

       /* homePage.clickFirstAcheterButtonTexts();
        waitForNSeconds(1);

        boolean isBannerDisplayed = driver.findElements(By.id("_evidon-banner-content")).size() < 1;
        captureScreenshot(driver, "Home Page - Banner button accept");
        assertTrue(isBannerDisplayed);

        driver.get("https://www.nespresso.com/pro/fr/fr/abonnement-professionnel");
        waitForNSeconds(1);

        driver.get("https://www.nespresso.com/pro/fr/fr/order/capsules/pro/ristretto-intenso-boite-capsule-cafe");
        waitForNSeconds(1);

        captureScreenshot(driver, "validation Panier Test");
        driver.findElement(By.id("ta-product-details__add-to-bag-button")).click();
        waitForNSeconds(1);

        driver.findElements(By.xpath("//*[text()='AJOUTER AU PANIER']")).get(0).click();
        waitForNSeconds(1);

        driver.findElement(By.id("ta-quantity-selector__custom-field")).sendKeys("50");
        waitForNSeconds(1);

        driver.findElement(By.id("ta-quantity-selector__custom-ok")).click();
        waitForNSeconds(1);

        driver.findElement(By.xpath("//*[text()='VOTRE PANIER']")).click();
        waitForNSeconds(1);

        driver.findElement(By.xpath("//*[text()='Valider votre panier']")).click();
        waitForNSeconds(1);*/
    }
}
