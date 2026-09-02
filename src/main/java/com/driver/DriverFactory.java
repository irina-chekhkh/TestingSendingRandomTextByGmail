package com.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

import java.util.Collections;

public class DriverFactory {
    public static WebDriver createDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver(getChromeOptions());
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                WebDriver driver = new FirefoxDriver(getFirefoxOptions());
                ((JavascriptExecutor) driver).executeScript(
                        "Object.defineProperty(navigator, 'webdriver', {get: () => undefined})"
                );
                return driver;
            default:
                return null;
        }
    }

    private static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--disable-infobars");
        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36");
        return options;
    }

    private static FirefoxOptions getFirefoxOptions() {
        System.setProperty("webdriver.firefox.marionette", "false");

        FirefoxOptions options = new FirefoxOptions();

        options.addArguments("--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:130.0) Gecko/20100101 Firefox/130.0");

        options.addPreference("dom.webdriver.enabled", false);
        options.addPreference("useAutomationExtension", false);

        options.addPreference("marionette.enabled", false);

        return options;
    }

}
