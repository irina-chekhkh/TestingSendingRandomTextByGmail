package com.page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WelcomePage extends BasePage {

    @FindBy(xpath = "//header//a[contains(@href,'signin')]")
    WebElement openButton;

    public WelcomePage() {
    }

    @Step("Open welcome page")
    public WelcomePage open(){
        logger.info("Open welcome page");
        driver.get("https://workspace.google.com/intl/ru/gmail/");
        return this;
    }

    @Step("Open login page")
    public LogInPage openLogInPage() {
        logger.info("Open login page");
        wait.until(ExpectedConditions.elementToBeClickable(openButton)).click();
        changePage();
        return new LogInPage();
    }

    private void changePage(){
        for (String windowHandle : driver.getWindowHandles()) {
            if(!windowHandle.equals(driver.getWindowHandle())){
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }
}
