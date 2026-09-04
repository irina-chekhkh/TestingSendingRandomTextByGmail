package com;

import com.component.EmailConfig;
import com.component.TestConstants;
import com.component.TextGenerator;
import com.driver.SingletonDriver;
import com.page.MainPage;
import com.structure.Letter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest {
    protected String mail;
    protected String password;
    protected static Letter expectedletter;
    protected static boolean isLogin = false;

    @Parameters("browser")
    @BeforeTest
    public void setUpTestDataAndDriver(String browser) {
        mail = EmailConfig.getEmail();
        password = EmailConfig.getPassword();

        String receiver = EmailConfig.getReceiverEmail();

        String title = TextGenerator.generateText(
                TestConstants.MIN_TITLE_LENGTH,
                TestConstants.MAX_TITLE_LENGTH);

        String text = TextGenerator.generateText(
                TestConstants.MIN_TEXT_LENGTH,
                TestConstants.MAX_TEXT_LENGTH);

        expectedletter = new Letter(receiver, title, text);
        SingletonDriver.getInstance(browser);
    }

    @AfterTest
    public void closeDriver() {
        if (isLogin) {
            new MainPage().logout(mail);
        }
        SingletonDriver.closeDriver();
    }
}
