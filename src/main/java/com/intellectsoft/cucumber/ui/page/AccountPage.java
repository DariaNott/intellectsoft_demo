package com.intellectsoft.cucumber.ui.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountPage extends BasePage {

    @FindBy(xpath = "//label[contains(@for,'loginform-login')]")
    private WebElement getLoginField;

    @FindBy(xpath = "//input[contains(@id,'loginform-login')]")
    private WebElement loginField;

    @FindBy(xpath = "//label[contains(@for,'loginform-password')]")
    private WebElement getPasswordField;

    @FindBy(xpath = "//input[contains(@id,'loginform-password')]")
    private WebElement passwordField;

    @FindBy(xpath = "//button[contains(@class,'btn-small auth-submit')]")
    private WebElement loginButton;

    @FindBy(xpath = "//button[contains(@id,'pass-button')]")
    private WebElement changePassword;

    @FindBy(xpath = "//div[contains(@id,'email-status')]")
    private WebElement changeEmail;

    @FindBy(xpath = "//input[contains(@id,'accesschangeform-password')]")
    private WebElement oldPassInputField;

    @FindBy(xpath = "//input[contains(@id,'submit-editting')]")
    private WebElement submittOldPass;

    @FindBy(xpath = "//div[contains(@class,'authorised-user')]")
    private WebElement userIsAuthorised;

    @FindBy(xpath = "//div[contains(@class,'anonymous-user')]")
    private WebElement userIsAnonymous;

    public AccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    
    public AccountPage logIn(String userName, String password) {
        LOGGER.info("Clicked on getLoginField");
        click(getLoginField);
        LOGGER.info("Username typed in loginField");
        loginField.sendKeys(userName);
        LOGGER.info("Clicked on getPasswordField");
        click(getPasswordField);
        LOGGER.info("Username typed in passwordField");
        passwordField.sendKeys(password);
        LOGGER.info("Clicked on loginButton");
        click(loginButton);
        return this;
    }

    public String getAuthorizationStatus() {
        String status = null;
        LOGGER.info("Receive authorization status.");
        if (elementExists(userIsAuthorised)) {
            status = "authorised";
        } else if (elementExists(userIsAnonymous)) {
            status = "anonymous";
        }
        return status;
    }

    private boolean elementExists(WebElement element) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .ignoring(WebDriverException.class)
                    .until(ExpectedConditions.visibilityOf(element));
            return element.isDisplayed();
        } catch (WebDriverException ex) {
            return false;
        }
    }
}
