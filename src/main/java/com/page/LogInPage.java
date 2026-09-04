package com.page;

import com.component.LoadConstants;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class LogInPage extends BasePage {

    public LogInPage() {
    }

    private void enterData(By inputLocator, String inputValue) {
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(inputLocator));
        emailField.sendKeys(inputValue);
    }

    private void sleep() {
        try {
            Thread.sleep(LoadConstants.ANTI_BOT_TIMEOUT);
        } catch (InterruptedException e) {
        }
    }

    private void clickButton(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    @Step("Enter email")
    public LogInPage enterEmail(String email) {
        logger.info("Entering email ({}) and clicking button", email);
        enterData(By.xpath("//input[@type='text' and @name='identifier']"), email);
        sleep();
        clickButton(By.xpath("//*[@id=\"identifierNext\"]//button"));
        return this;
    }

    @Step("Enter password")
    public MainPage enterPassword(String password) {
        logger.info("Entering password ({}) and clicking button", password);
        enterData(By.xpath("//*[@id=\"password\"]//input"), password);
        sleep();
        clickButton(By.xpath("//*[@id=\"passwordNext\"]//button"));
        return new MainPage();
    }

    public boolean isPasswordPageOpen() {
        logger.info("Checking if password page is open");
        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='password']//input[@type='password']")));
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }
}
