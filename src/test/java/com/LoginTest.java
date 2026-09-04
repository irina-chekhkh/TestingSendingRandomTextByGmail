package com;

import com.page.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void loginWithRightData() {
        boolean isOpenPage = new WelcomePage()
                .open()
                .openLogInPage()
                .enterEmail(mail)
                .enterPassword(password)
                .isPageOpen();
        isLogin = isOpenPage;
        Assert.assertTrue(isOpenPage);
    }

    @Test
    public void loginWithWrongPassword() {
        ResourcesDataReader dataReader = new ResourcesDataReader("wrong-data");
        boolean isOpenPage = new WelcomePage()
                .open()
                .openLogInPage()
                .enterEmail(mail)
                .enterPassword(dataReader.getData("password"))
                .isPageOpen();
        Assert.assertFalse(isOpenPage);
    }

    @Test
    public void loginWithWrongEmail() {
        ResourcesDataReader dataReader = new ResourcesDataReader("wrong-data");
        boolean isOpenPage = new WelcomePage()
                .open()
                .openLogInPage()
                .enterEmail(dataReader.getData("email"))
                .isPasswordPageOpen();
        Assert.assertFalse(isOpenPage);
    }
}
