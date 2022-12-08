package com.nespresso.selenium.testing.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    @FindBy(xpath = "//*[text()='CONNECTEZ-VOUS']")
    @CacheLookup
    WebElement authenticationButton;

    @FindBy(xpath = "//*[@id=\"ta-header-username\"]")
    @CacheLookup
    WebElement usernameText;

    @FindBy(xpath = "//*[@id=\"ta-header-password\"]")
    @CacheLookup
    WebElement passwordText;

    @FindBy(id = "ta-header-remember-me")
    @CacheLookup
    WebElement rememberMeCheckBox;

    @FindBy(id = "ta-login-form__submit")
    @CacheLookup
    WebElement loginSubmitButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setUsername(String username) {
        this.usernameText.sendKeys(username);
    }

    public void setPassword(String password) {
        this.passwordText.sendKeys(password);
    }

    public void clickSubmit() {
        this.loginSubmitButton.click();
    }

    public void clickLoginButton() {
        this.authenticationButton.click();
    }

    public void clickRememberMeCheckBox() {
        this.rememberMeCheckBox.click();
    }
}
