package com.page;

import com.structure.Letter;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SentPage extends AbstractPage {
    public SentPage() {
    }

    public LetterPage findLetter(Letter letter) {
        wait.until(ExpectedConditions
                .elementToBeClickable(
                        By.xpath(String.format("//tr[.//*[text()='%s']]", letter.getTitle()))
                )
        ).click();
        return new LetterPage();
    }
}
