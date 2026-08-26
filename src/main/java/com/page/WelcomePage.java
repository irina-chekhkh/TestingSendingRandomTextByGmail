package com.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WelcomePage extends AbstractPage {

    @FindBy(xpath = "//header//a[contains(@href,'signin')]")
    WebElement openButton;

    public WelcomePage() {
        driver.get("https://workspace.google.com/intl/ru/gmail/");
    }

    public LogInPage openLogInPage() {
        openButton.click();
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
