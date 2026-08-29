package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends AbstractPage {

    public MainPage() {
    }

    public boolean isPageOpen(){
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='q']")));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public NavigationMenu getNavigationMenu() {
        return new NavigationMenu();
    }

    public void logout(String email) {
        driver.findElement(By.xpath(String.format("//a[contains(@aria-label,'%s')]",email))).click();
        WebElement iframe = driver.findElement(By.xpath("//iframe[@name='account']"));
        driver.switchTo().frame(iframe);
        WebElement element = driver.findElement(By.xpath("//a[contains(@href, 'Logout')]"));
        element.click();
    }

}
