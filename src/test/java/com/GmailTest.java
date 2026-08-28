package com;

import com.component.TextGenerator;
import com.page.LetterBox;
import com.driver.SingletonDriver;
import com.page.DraftPage;
import com.page.MainPage;
import com.page.NavigationMenu;
import com.page.WelcomePage;
import com.structure.Letter;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;



public class GmailTest {

    private String mail;
    private String password;
    private Letter expectedletter;

    @BeforeSuite
    public void createDriver() {
        ResourcesDataReader reader = new ResourcesDataReader("email-data");
        mail = reader.getData("user.email");
        password = reader.getData("user.password");
        String receiver = reader.getData("receiver.email");
        String title = TextGenerator.generateText(1,10);
        String text = TextGenerator.generateText(0,100);
        expectedletter = new Letter(receiver,title,text);
        SingletonDriver.getInstance();
    }

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

    @AfterSuite
    public void closeDriver() {
        new MainPage().logout();
        SingletonDriver.closeDriver();
    }
}
