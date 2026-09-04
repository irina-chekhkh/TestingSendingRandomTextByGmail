package com;

import com.page.DraftPage;
import com.page.LetterBox;
import com.page.NavigationMenu;
import com.structure.Letter;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SendLetterTest extends BaseTest {
    @Test
    public void sendLetterFromDraft() {
        DraftPage page = new LetterBox().sendLetterBox();
        Assert.assertThrows(Exception.class, () -> page.openLetterInDraftPage(expectedletter));
        Letter letter = new NavigationMenu()
                .openSentPage()
                .findLetter(expectedletter)
                .getLetter();
        Assert.assertEquals(letter, expectedletter);
    }
}
