package com.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AmazonLoginTest {

    private WebDriver driver;
    private AmazonLoginPage loginPage;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        loginPage = new AmazonLoginPage(driver);
    }

    @Test
    public void testValidLogin() {
        loginPage.navigateTo();
        loginPage.enterEmail("aksh.patel78@gmail.com");
        loginPage.clickContinue();
        loginPage.enterPassword("123456");
        loginPage.clickSignIn();
        // Add assertions here to verify successful login
    }

    @Test
    public void testInvalidEmail() {
        loginPage.navigateTo();
        loginPage.enterEmail("invalid_email");
        loginPage.clickContinue();
        // Add assertions here to verify error message
    }

    @Test
    public void testInvalidPassword() {
        loginPage.navigateTo();
        loginPage.enterEmail("aksh.patel78@gmail.com");
        loginPage.clickContinue();
        loginPage.enterPassword("invalid_password");
        loginPage.clickSignIn();
        // Add assertions here to verify error message
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}