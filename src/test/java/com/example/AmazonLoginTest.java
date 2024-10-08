package com.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
    //private String testEnvUrl = System.getProperty("TEST_ENV_URL", "https://www.amazon.com");
    //https://www.snapdeal.com/
    private String testEnvUrl = System.getProperty("TEST_ENV_URL", "https://www.snapdeal.com");
    
    private String browser = System.getProperty("BROWSER", "edge");

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
                //WebDriverManager.chromedriver().setup();
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
        }
        loginPage = new AmazonLoginPage(driver, testEnvUrl);  // Assuming AmazonLoginPage class exists
    }

    @Test
    public void testValidLogin() {
        loginPage.navigateTo();
        // Use XPath to locate the email input field
        By emailLocator = By.xpath("//*[@id='userName']");
        System.out.println("webpage hit.......");
        loginPage.enterEmail("akshitpatel574@gmail.com");
        loginPage.clickContinue();
        System.out.println("webpage hit me hit mee.......");
        // Use XPath to locate the password input field
        By passwordLocator = By.xpath("//*[@id='j_password']");
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
