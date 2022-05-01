package com.intellectsoft.cucumber.ui.component;


import com.intellectsoft.cucumber.ui.page.AccountPage;
import com.intellectsoft.cucumber.ui.page.BasePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Header {

    private WebDriver driver;

    protected static final Logger LOGGER = Logger.getLogger(BasePage.class);

    @FindBy(xpath = "//li/a[contains(@href,'showtimes')]")
    private WebElement scheduleButton;

    @FindBy(xpath = "//li/a[contains(@href,'movies')]")
    private WebElement moviesButton;

    @FindBy(xpath = "//div[contains(@class,'city-selector')]")
    private WebElement cityButton;

    @FindBy(xpath = "//a[contains(@href,'enter')]")
    private WebElement logInButton;

    @FindBy(xpath = "//a[contains(@class,'logout')]")
    private WebElement logOutButton;

    @FindBy(xpath = "//ul[@id='citylist']/li//a")
    private List<WebElement> cityList;

    public Header(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public AccountPage goToLogIn() {
        LOGGER.info("Clicked on logInButton.");
        waitClickability(logInButton);
        logInButton.click();
        return new AccountPage(driver);
    }
    
    public AccountPage logOut() {
        LOGGER.info("Clicked on logOutButton.");
        waitClickability(logOutButton);
        logOutButton.click();
        return new AccountPage(driver);
    }

    private WebElement waitClickability(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(40)).until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }
}
