package com.page;

import com.structure.Letter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LetterBox extends AbstractPage {

    public LetterBox() {
    }

    public LetterBox fillLetter(Letter letter) {
        addReceiver(letter.getReceiver());
        addTitle(letter.getTitle());
        addText(letter.getText());
        return this;
    }

    public void addReceiver(String receiver) {
        WebElement input = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("div[name=to] input")
                ));
        input.sendKeys(receiver);
    }

    public void addTitle(String title) {
        WebElement titleInput = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//form//input[@name='subjectbox']")
                ));
        titleInput.sendKeys(title);
    }

    public void addText(String text) {
        WebElement textBox = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[@role='textbox']")));
        textBox.sendKeys(text);
    }

    public MainPage saveLetterBox() {
        wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//h2[.//div[text()='Написать:'] and .//span[text()='Черновик сохранен']]")
                )
        );
        driver.findElement(By.xpath("//button[@aria-label='Сохранить и закрыть']")).click();
        return new MainPage();
    }

    public DraftPage sendLetterBox() {
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//div[@role='button' and text()='Отправить']"))).click();
        return new DraftPage();
    }

    public Letter getLetter() {
        String receiver = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//span[@email]")
                )).getText();

        String title = driver.findElement(
                By.cssSelector("input[name=subject]")
        ).getAttribute("value");

        String text = driver.findElement(
                By.xpath("//div[@role='textbox']//div")
        ).getText();

        return new Letter(receiver, title, text);
    }
}
