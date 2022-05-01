package com.intellectsoft.cucumber.ui.page;

import com.intellectsoft.core.config.EnvConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //for a demo
    public MainPage openWebsite() {
        driver.get(EnvConfig.getEnvironment().getWebUrl());
        return this;
    }

}
