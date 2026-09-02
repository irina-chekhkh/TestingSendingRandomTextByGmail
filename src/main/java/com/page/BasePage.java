package com.page;

import com.component.LoadConstants;
import com.driver.SingletonDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    protected final Logger logger = LogManager.getLogger(getClass());
    protected WebDriverWait wait;
    protected WebDriver driver;

    protected BasePage() {
        this.driver = SingletonDriver.getDriver();
        wait = new WebDriverWait(driver, Duration.ofMillis(LoadConstants.MAX_TIME_lOAD));
        PageFactory.initElements(driver, this);
    }
}
