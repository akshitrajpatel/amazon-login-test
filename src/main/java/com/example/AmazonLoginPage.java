package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonLoginPage {

    private WebDriver driver;
    private String url; // Declared 'url' as a class-level variable
    
    @FindBy(id = "ap_email")
    private WebElement emailInput;

    @FindBy(id = "continue")
    private WebElement continueButton;

    @FindBy(id = "ap_password")
    private WebElement passwordInput;

    @FindBy(id = "signInSubmit")
    private WebElement signInButton;

    public AmazonLoginPage(WebDriver driver, String url) {
        this.driver = driver;
        this.url = url;
        PageFactory.initElements(driver, this);
    }

    public void navigateTo() {
        String addUri= "/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2F%3Fref_%3Dnav_ya_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=usflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0";
        driver.get(url + addUri);
    }

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void clickContinue() {
        continueButton.click();
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickSignIn() {
        signInButton.click();
    }
}
