package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NavigationMenu extends AbstractPage {

    @FindBy(xpath = "//div[@role='navigation']//div[@role='button']")
    private WebElement openLetterButton;

    public NavigationMenu() {
    }

    public LetterBox openLetterBox() {
        wait.until(ExpectedConditions.elementToBeClickable(openLetterButton));
        openLetterButton.click();
        return new LetterBox();
    }

    public DraftPage openDraftPage() {
        WebElement draftButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@href,'drafts')]")));
        draftButton.click();
        return new DraftPage();
    }

    public SentPage openSentPage(){
        driver.findElement(By.xpath("//div[@role='navigation']//span[a[contains(@href,'sent')]]")).click();
        return new SentPage();
    }
}
