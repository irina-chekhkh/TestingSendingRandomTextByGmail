package com.page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NavigationMenu extends BasePage {

    @FindBy(xpath = "//div[@role='navigation']//div[@role='button']")
    private WebElement openLetterButton;

    public NavigationMenu() {
        super();
    }

    @Step("Open letter box")
    public LetterBox openLetterBox() {
        logger.info("Open letter box");
        wait.until(ExpectedConditions.elementToBeClickable(openLetterButton)).click();
        return new LetterBox();
    }

    @Step("Open draft page")
    public DraftPage openDraftPage() {
        logger.info("Open draft page");
        By draftButtonLocator = By.xpath("//a[contains(@href,'drafts')]");
        wait.until(ExpectedConditions.elementToBeClickable(draftButtonLocator)).click();
        return new DraftPage();
    }

    @Step("Open sent page")
    public SentPage openSentPage() {
        logger.info("Open sent page");
        By sentButtonLocator = By.xpath("//div[@role='navigation']//span[a[contains(@href,'sent')]]");
        wait.until(ExpectedConditions.elementToBeClickable(sentButtonLocator)).click();
        return new SentPage();
    }
}