package com.page;

import com.component.LoadConstants;
import com.driver.SingletonDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbstractPage {
    protected WebDriverWait wait;
    protected WebDriver driver;

    protected AbstractPage() {
        this.driver = SingletonDriver.getDriver();
        wait = new WebDriverWait(driver, Duration.ofMillis(LoadConstants.MAX_TIME_lOAD));
        PageFactory.initElements(driver, this);
    }
}
