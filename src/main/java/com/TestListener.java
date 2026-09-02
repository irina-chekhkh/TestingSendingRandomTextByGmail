package com;

import com.driver.SingletonDriver;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {

        byte[] screenshot = ((TakesScreenshot) SingletonDriver.getDriver())
                .getScreenshotAs(OutputType.BYTES);

        Allure.addAttachment(
                "Screenshot",
                "image/png",
                new java.io.ByteArrayInputStream(screenshot),
                ".png"
        );
    }
}

