package com.intellectsoft.cucumber.step;

import com.intellectsoft.core.config.EnvConfig;
import com.intellectsoft.core.driver.DriverFactory;
import com.intellectsoft.cucumber.ui.page.MainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

/**
 * Step definitions class or "steps class".
 * Is actually a class that connects your steps in .feature file with actual java code using:
 *
 * @Given, @Then, @When, @But, @And annotations.
 * If you want to run your tests in a few threads it's highly recommended avoiding static variable declaration in such classes.
 */
public class GeneralSteps {

    private MainPage mainPage;
    private EnvConfig config;

    public GeneralSteps() {
        mainPage = new MainPage(DriverFactory.getDriver());
        config = EnvConfig.getEnvironment();
    }

    @Given("I open planetakino.ua Main page")
    public void openMainPage() {
        String url = EnvConfig.getEnvironment().getWebUrl();
        DriverFactory.getDriver().get(url);
    }

    @Given("I login as a valid user")
    public void logInAsValidUser() {
        mainPage.getHeader().goToLogIn().logIn(config.getUsername(), config.getPassword());
    }

    @When("I login with user name {string} and password {string}")
    public void logInSomeCredentials(String username, String password) {
        mainPage.getHeader().goToLogIn().logIn(username, password);
    }
}
