package com.page;

import com.structure.Letter;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SentPage extends BasePage {
    public SentPage() {
    }

    @Step("Find and open letter in sent page")
    public LetterPage findLetter(Letter letter) {
        logger.info("Find and open letter in sent page");
        wait.until(ExpectedConditions
                .elementToBeClickable(
                        By.xpath(String.format("//tr[.//*[text()='%s']]", letter.getTitle()))
                )
        ).click();
        return new LetterPage();
    }
}
