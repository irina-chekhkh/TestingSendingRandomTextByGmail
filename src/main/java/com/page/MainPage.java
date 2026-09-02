package com.page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {

    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchInput;

    public MainPage() {
    }

    @Step("Check if main page is open")
    public boolean isPageOpen(){
        try {
            logger.info("Checking if main page is open");
            wait.until(ExpectedConditions.visibilityOf(searchInput));
            return true;
        } catch (Exception e) {
            logger.error("Main page is not open");
            return false;
        }
    }

    public NavigationMenu getNavigationMenu() {
        logger.info("Opening navigation menu");
        return new NavigationMenu();
    }


    @Step("Log out from account for user: {email}")
    public void logout(String email) {
        logger.info("Log out from account for user: {}", email);
        WebElement profileButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(String.format("//a[contains(@aria-label,'%s')]", email))
        ));
        profileButton.click();

        WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//iframe[@name='account']")
        ));
        driver.switchTo().frame(iframe);

        WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(@href, 'Logout')]")
        ));
        logoutButton.click();
    }

}
