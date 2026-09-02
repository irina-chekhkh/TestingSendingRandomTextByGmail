package com;

import com.page.LetterBox;
import com.page.DraftPage;
import com.page.NavigationMenu;
import com.page.WelcomePage;
import com.structure.Letter;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;


public class GmailTest extends BaseTest {

    @Test
    public void loginTest() {
        boolean isOpenPage = new WelcomePage()
                .open()
                .openLogInPage()
                .enterEmail(mail)
                .enterPassword(password)
                .isPageOpen();
        Assert.assertTrue(isOpenPage);
    }

    @Test(dependsOnMethods = "loginTest")
    public void saveLetterToDraft() {
        Letter actualletter = new NavigationMenu()
                .openLetterBox()
                .fillLetter(expectedletter)
                .saveLetterBox()
                .getNavigationMenu()
                .openDraftPage()
                .openLetterInDraftPage(expectedletter).getLetter();
        Assert.assertEquals(expectedletter, actualletter);
    }

    @Test(dependsOnMethods = "saveLetterToDraft")
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
