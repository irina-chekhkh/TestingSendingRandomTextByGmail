package com;

import com.component.EmailConfig;
import com.component.TestConstants;
import com.component.TextGenerator;
import com.driver.SingletonDriver;
import com.page.MainPage;
import com.structure.Letter;
import org.testng.annotations.*;

public class BaseTest {
    protected String mail;
    protected String password;
    protected Letter expectedletter;

    @Parameters("browser")
    @BeforeClass
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

    @AfterClass
    public void closeDriver() {
        new MainPage().logout(mail);
        SingletonDriver.closeDriver();
    }
}
