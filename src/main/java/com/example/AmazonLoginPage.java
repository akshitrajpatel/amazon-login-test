package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonLoginPage {

    private WebDriver driver;
    private String url; // Declared 'url' as a class-level variable
    
    @FindBy(id = "userName")
    private WebElement emailInput;

    @FindBy(id = "checkUser")
    private WebElement btn;

    @FindBy(id = "j_password")
    private WebElement passwordInput;

    @FindBy(id = "userSignup")
    private WebElement continueBtn;

    public AmazonLoginPage(WebDriver driver, String url) {
        this.driver = driver;
        this.url = url;
        PageFactory.initElements(driver, this);
    }

    public void navigateTo() {
        String addUri= "/";
        driver.get(url + addUri);
    }

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void clickContinue() {
        btn.click();
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickSignIn() {
        continueBtn.click();
    }
}
