package com.page;

import com.structure.Letter;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class DraftPage extends AbstractPage {
    public DraftPage() {
    }

    public LetterBox findLetter(Letter letter){
        wait.withTimeout(Duration.ofSeconds(3)).until(ExpectedConditions
                        .elementToBeClickable(
                                By.xpath(String.format("//tr[.//*[text()='%s']]",letter.getTitle()))
                        )
                ).click();
        return new LetterBox();
    }
}
