package com.nespresso.selenium.testing.testclasses;

import com.nespresso.selenium.testing.enums.Browser;
import com.nespresso.selenium.testing.utilities.PropertyConfiguration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;

public class BaseClass {

    PropertyConfiguration propertyConfig =  new PropertyConfiguration();
    public final String baseUrl = propertyConfig.getBaserUrl();
    public final String username = propertyConfig.getUsername();
    public final String password = propertyConfig.getPassword();
    public static WebDriver driver;

    public static Logger logger;

    @BeforeClass
    @Parameters(value = "browser")
    public void setup(String browser) {
        WebDriverManager.chromedriver().setup();
        if (browser.equals(Browser.CHROME.getLabel())) {
            driver = new ChromeDriver();
        } else if (browser.equals(Browser.FIREFOX.getLabel())) {
            driver = new FirefoxDriver();
        } else if (browser.equals(Browser.SAFARI.getLabel())) {
            driver = new SafariDriver();
        } else {
            driver = new ChromeDriver();
        }
        logger = Logger.getLogger("E-Banking");
        PropertyConfigurator.configure(System.getProperty("user.dir").concat("/log4j.properties"));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    public void captureScreenshot(WebDriver driver, String testName) throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
        File destionationFile = new File(System.getProperty("user.dir").concat("/screenshots/").concat(testName).concat(".png"));
        FileUtils.copyFile(sourceFile, destionationFile);
        System.out.println("***** Screenshot taken *****");
    }
}
