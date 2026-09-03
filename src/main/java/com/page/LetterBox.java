package com.page;

import com.structure.Letter;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LetterBox extends BasePage {

    public LetterBox() {
    }

    @Step("Fill mail, title and text")
    public LetterBox fillLetter(Letter letter) {
        addReceiver(letter.getReceiver());
        addTitle(letter.getTitle());
        addText(letter.getText());
        return this;
    }

    public void addReceiver(String receiver) {
        logger.info("Filling receiver with address: {}", receiver);
        WebElement input = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("div[name=to] input")
                ));
        input.sendKeys(receiver);
    }

    public void addTitle(String title) {
        logger.info("Filling title with subject: {}", title);
        WebElement titleInput = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//form//input[@name='subjectbox']")
                ));
        titleInput.sendKeys(title);
    }

    public void addText(String text) {
        logger.info("Filling text with subject: {}", text);
        WebElement textBox = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[@role='textbox']")));
        textBox.sendKeys(text);
    }


    @Step("Save letter in draft")
    public MainPage saveLetterBox() {
        logger.info("Saving letter in draft");
        wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//h2[.//div[text()='Написать:'] and .//span[text()='Черновик сохранен']]")
                )
        );
        driver.findElement(By.xpath("//button[@aria-label='Сохранить и закрыть']")).click();
        return new MainPage();
    }


    @Step("Send letter")
    public DraftPage sendLetterBox() {
        logger.info("Sending letter");
        WebElement sendButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@role='button' and text()='Отправить']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sendButton);
        return new DraftPage();
    }

    @Step("Read all information from letter")
    public Letter getLetter() {
        logger.info("Reading receiver");
        String receiver = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//span[@email]")
                )).getText();

        logger.info("Reading title");
        String title = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.cssSelector("input[name=subject]")
                )).getAttribute("value");

        logger.info("Reading text");
        String text = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//div[@role='textbox']//div")
                )).getText();

        return new Letter(receiver, title, text);
    }
}
