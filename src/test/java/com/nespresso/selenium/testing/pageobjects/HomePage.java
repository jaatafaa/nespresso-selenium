package com.nespresso.selenium.testing.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

public class HomePage {

    WebDriver driver;

    @FindBy(id = "_evidon-banner-acceptbutton")
    @CacheLookup
    WebElement bannerAcceptButton;

    @FindBy(linkText = "Machines")
    @CacheLookup
    WebElement machinesLinkText;

    @FindBy(className = "CheckoutActionButton")
    @CacheLookup
    List<WebElement> acheterButtonTexts;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickAcceptButton() {
        this.bannerAcceptButton.click();
    }

    public void clickNespressoProfessionnelLink() {
        this.machinesLinkText.click();
    }

    public void clickFirstAcheterButtonTexts() {
        System.out.println("#######   " + acheterButtonTexts.size());
    }
}
