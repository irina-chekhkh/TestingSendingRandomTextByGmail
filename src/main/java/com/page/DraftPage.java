package com.page;

import com.component.LoadConstants;
import com.structure.Letter;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class DraftPage extends BasePage {
    public DraftPage() {
    }

    @Step("Find and open letter in the draft page")
    public LetterBox openLetterInDraftPage(Letter letter){
        logger.info("Opening letter in the draft page");
        wait.withTimeout(Duration.ofMillis(LoadConstants.MIN_TIME_lOAD)).until(ExpectedConditions
                        .elementToBeClickable(
                                By.xpath(String.format("//tr[.//*[text()='%s']]",letter.getTitle()))
                        )
                ).click();
        return new LetterBox();
    }
}
