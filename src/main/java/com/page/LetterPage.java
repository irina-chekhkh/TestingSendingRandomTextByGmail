package com.page;

import com.structure.Letter;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LetterPage extends AbstractPage{
    public LetterPage() {
    }

    public Letter getLetter(){
        String title = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[@role='main']//h2"))).getText();

        String receiver= wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//span[@email and @class='g2']"))).getText();

        String text = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[@dir='ltr']//div[@dir='ltr']"))).getText();
        return new Letter(receiver,title,text);
    }

}
