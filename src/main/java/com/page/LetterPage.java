package com.page;

import com.structure.Letter;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LetterPage extends BasePage {
    public LetterPage() {
    }

    @Step("Read letter")
    public Letter getLetter() {
        String title = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[@role='main']//h2"))).getText();
        logger.info("Reading title : {}", title);

        String receiver = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//span[@email and @class='g2']"))).getAttribute("data-hovercard-id");

        logger.info("Reading receiver : {}", receiver);

        String text = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[@dir='ltr']//div[@dir='ltr']"))).getText();
        logger.info("Reading text : {}", text);

        return new Letter(receiver, title, text);
    }

}
