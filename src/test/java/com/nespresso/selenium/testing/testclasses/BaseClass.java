package com.nespresso.selenium.testing.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.logging.Logger;

public class BaseClass {

    public static final String BASE_URL = "https://demo.guru99.com/v3/index.php";
    public static final String USERNAME = "mngr461161";
    public static final String PASSWORD = "yvYvYsU";
    public static WebDriver driver;

    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private static final String SYSTEM_OS = System.getProperty("os.name");
    private static final String LINUX_CHROME_DRIVER = System.getProperty("user.dir").concat("drivers/linux/chromedriver");
    private static final String MACOSX_CHROME_DRIVER = System.getProperty("user.dir").concat("drivers/macosx/chromedriver");
    private static final String WINDOWS_CHROME_DRIVER = System.getProperty("user.dir").concat("drivers/windows/chromedriver.exe");

    @BeforeClass
    public void setup() {
        if (SYSTEM_OS.startsWith("LIN")) {
            System.setProperty("webdriver.chrome.driver", LINUX_CHROME_DRIVER);
        }
        if(SYSTEM_OS.startsWith("WINDOWS")) {
            System.setProperty("webdriver.chrome.driver", WINDOWS_CHROME_DRIVER);
        }
        if(SYSTEM_OS.startsWith("Mac")) {
            System.setProperty("webdriver.chrome.driver", MACOSX_CHROME_DRIVER);
        } else {
            logger.info("SORRY, THE SYSTEM YOU ARE USING: "+ SYSTEM_OS +" ARE NOT YET SUPPORTED");
        }
        driver = new ChromeDriver();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
