package com.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AmazonLoginTest {

    private WebDriver driver;
    private AmazonLoginPage loginPage;  // Changed type to AmazonLoginPage
    private String testEnvUrl = System.getProperty("TEST_ENV_URL", "https://www.amazon.com");
    private String browser = System.getProperty("BROWSER", "chrome");

    @BeforeMethod
    public void setup() {
        switch (browser.toLowerCase()) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
        }
        loginPage = new AmazonLoginPage(driver, testEnvUrl);  // Assuming AmazonLoginPage class exists
    }

    @Test
    public void testValidLogin() {
        loginPage.navigateTo();
        loginPage.enterEmail("aksh.patel78@gmail.com");
        loginPage.clickContinue();
        loginPage.enterPassword("12345");
        loginPage.clickSignIn();
        // Add assertions here to verify successful login
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
