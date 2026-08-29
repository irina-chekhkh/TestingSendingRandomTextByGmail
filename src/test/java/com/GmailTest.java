package com;

import com.page.LetterBox;
import com.page.DraftPage;
import com.page.NavigationMenu;
import com.page.WelcomePage;
import com.structure.Letter;
import org.testng.Assert;
import org.testng.annotations.Test;


public class GmailTest extends BaseTest {

    @Test
    public void loginTest() {
        boolean isOpenPage = new WelcomePage()
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
                .findLetter(expectedletter).getLetter();
        Assert.assertEquals(expectedletter, actualletter);
    }

    @Test(dependsOnMethods = "saveLetterToDraft")
    public void sendLetterFromDraft() {
        DraftPage page = new LetterBox().sendLetterBox();
        Assert.assertThrows(Exception.class, () -> page.findLetter(expectedletter));
        Letter letter = new NavigationMenu()
                .openSentPage()
                .findLetter(expectedletter)
                .getLetter();
        Assert.assertEquals(letter, expectedletter);
    }

}
