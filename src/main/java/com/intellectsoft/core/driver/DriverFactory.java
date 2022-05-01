package com.intellectsoft.core.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Driver factory class holds all webdriver instances that can be created during test run.
 * Designed to be thread-safe (for further possible extension).
 */
public class DriverFactory {

    private static ThreadLocal<WebDriver> driverStorage = new ThreadLocal<>();

    private DriverFactory() {

    }

    /**
     * Returns webdriver assigned to current thread.
     *
     * @param <T> - WebDriver actual implementation
     * @return webdriver object or null if driver object wasn't found.
     */

    @SuppressWarnings("unchecked")
    public static <T extends RemoteWebDriver> T getDriver() {
        WebDriver driver = driverStorage.get();
        if (driver == null || isSessionDown()) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driverStorage.set(driver);
        }
        return (T) driver;
    }

    public static boolean isSessionDown() {
        try {
            driverStorage.get().getTitle();
            return false;
        } catch (NoSuchSessionException ex) {
            return true;
        }
    }

}