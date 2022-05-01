package com.intellectsoft.cucumber.step;

import com.intellectsoft.core.config.EnvConfig;
import com.intellectsoft.core.driver.DriverFactory;
import com.intellectsoft.cucumber.ui.page.AccountPage;
import com.intellectsoft.cucumber.ui.page.MainPage;
import io.cucumber.java.uk.Дано;
import io.cucumber.java.uk.Коли;
import io.cucumber.java.uk.Тоді;
import org.junit.Assert;

/**
 * Step definitions class can be written in a lot of different languages.
 * To force cucumber to the proper language, in the beginning of the file you should specify something like this:
 * #language: uk
 * However, we recommend to use English, for customers)
 */
public class BonusSteps {

    private MainPage mainPage;
    private AccountPage accountPage;
    private EnvConfig config;

    public BonusSteps() {
        mainPage = new MainPage(DriverFactory.getDriver());
        accountPage = new AccountPage(DriverFactory.getDriver());
        config = EnvConfig.getEnvironment();
    }

    @Дано("я заходжу на головну сторінку planetakino.ua")
    public void openMainPage() {
        String url = EnvConfig.getEnvironment().getWebUrl();
        DriverFactory.getDriver().get(url);
    }

    @Дано("я авторизуюсь із правильним логіном та паролем")
    public void logInAsValidUser() {
        mainPage.getHeader().goToLogIn().logIn(config.getUsername(), config.getPassword());
    }

    @Коли("я авторизуюсь з логіном {string} та паролем {string}")
    public void logInSomeCredentials(String username, String password) {
        mainPage.getHeader().goToLogIn().logIn(username, password);
    }

    @Тоді("авторизаційний статус повинен бути {string}")
    public void checkLogOut(String expectedStatus) {
        String actualStatus = accountPage.getAuthorizationStatus();
        Assert.assertEquals("User has wrong status!", expectedStatus, actualStatus);
    }
}
