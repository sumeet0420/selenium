package com.triscent.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public final class DriverSetup {

    private static WebDriver driver;

    //      Hiding the Constructor
    private DriverSetup() {
    }

    //Method to create the common setting
    private static void driverCommonSetting() {
        //Ensure the driver is set by using any of open* method
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    //Method to invoke Firefox Driver
    public static WebDriver openFirefox() {
        driver = new FirefoxDriver();
        driverCommonSetting();
        return driver;
    }

    //Method to invoke Chrome Driver
    public static WebDriver openChrome() {
        driver = new ChromeDriver();
        driverCommonSetting();
        driver.manage().window().maximize();
        return driver;
    }

    public static boolean isElementPresent(By by) {
        try {
            driver.findElements(by);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public static boolean isElementPresent(WebElement element) {
        return element == null ? true : false;
    }

    public static void closeBrowser() {
        driver.close();
    }

    public static void quitBrowser() {
        driver.quit();
    }


}
