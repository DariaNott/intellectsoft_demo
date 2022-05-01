package com.intellectsoft.cucumber.step;

import com.intellectsoft.core.driver.DriverFactory;
import com.intellectsoft.cucumber.ui.page.AccountPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

/**
 * Step definitions class or "steps class".
 * Is actually a class that connects your steps in .feature file with actual java code using:
 *
 * @Given, @Then, @When, @But, @And annotations.
 * If you want to run your tests in a few threads it's highly recommended avoiding static variable declaration in such classes.
 */
public class AccountSteps {

    private AccountPage accountPage;

    public AccountSteps() {
        accountPage = new AccountPage(DriverFactory.getDriver());
    }

    @Then("user authorized successfully")
    public void checkLogIn() {
        String status = accountPage.getAuthorizationStatus();
        Assert.assertEquals("User is not authorized!", "authorised", status);
    }

    @Then("user authorization status should be {string}")
    public void checkLogOut(String expectedStatus) {
        String actualStatus = accountPage.getAuthorizationStatus();
        Assert.assertEquals("User has wrong status!", expectedStatus, actualStatus);
    }

}
