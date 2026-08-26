package com.driver;

import org.openqa.selenium.WebDriver;

public class SingletonDriver {
    private static WebDriver driver;
    private static SingletonDriver instance;

    private SingletonDriver() {
    }

    public static SingletonDriver getInstance() {
        if (instance == null) {
            instance = new SingletonDriver();
        }
        if (driver == null) {
            driver = DriverFactory.createDriver();
        }
        return instance;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
