package com.intellectsoft.cucumber.hook;

import com.intellectsoft.core.driver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/**
 * Hooks classes usually contains @Before and @After each scenarios annotations.
 * It's a nica place to perform general preparations, or after test cleanup and take screenshots on failure
 */
public class Hook {

    @Before
    public void beforeEachTest() {
        //it's also possible to do something before each scenario
    }

    @After
    public void afterEachTest(Scenario scenario) {
        if (scenario.isFailed()) {
            if (!DriverFactory.isSessionDown()) {
                final byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver())
                        .getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", scenario.getName() + " screenshot");
            }
        }
        DriverFactory.getDriver().quit();
    }
}
