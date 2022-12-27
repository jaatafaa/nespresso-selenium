package com.nespresso.selenium.testing.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {

    WebDriver driver;

    @FindBy(xpath = "/html/body/div[2]/header/div/div[1]/div/div/div/div/div/div[1]/button")
    @CacheLookup
    WebElement authenticationButton;

    @FindBy(xpath = "/html/body/div[2]/header/div/div[1]/div/div/div/div/div/div[1]/div/div/div/form/div[1]/div/input")
    @CacheLookup
    WebElement usernameText;

    @FindBy(xpath = "/html/body/div[2]/header/div/div[1]/div/div/div/div/div/div[1]/div/div/div/form/div[2]/div/input")
    @CacheLookup
    WebElement passwordText;

    @FindBy(xpath = "/html/body/div[2]/header/div/div[1]/div/div/div/div/div/div[1]/div/div/div/form/div[3]/div/label/input")
    @CacheLookup
    WebElement rememberMeCheckBox;

    @FindBy(xpath = "/html/body/div[2]/header/div/div[1]/div/div/div/div/div/div[1]/div/div/div/form/button")
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

    public void fillUserInfos(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public void clickRememberMeCheckBox() {
        this.rememberMeCheckBox.click();
    }
}
