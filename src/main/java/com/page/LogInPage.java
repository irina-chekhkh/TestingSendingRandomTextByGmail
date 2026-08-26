package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class LogInPage extends AbstractPage {

    public LogInPage() {
    }

    private void enterData(By inputLocator, String inputValue) {
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(inputLocator));
        emailField.sendKeys(inputValue);
    }

    private void sleep() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {}
    }

    private void clickButton(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public LogInPage enterEmail(String email) {
        enterData(By.id("identifierId"), email);
        sleep();
        clickButton(By.xpath("//*[@id=\"identifierNext\"]//button"));
        return this;
    }

    public MainPage enterPassword(String password) {
        enterData(By.xpath("//*[@id=\"password\"]//input"), password);
        sleep();
        clickButton(By.xpath("//*[@id=\"passwordNext\"]//button"));
        return new MainPage();
    }
}
