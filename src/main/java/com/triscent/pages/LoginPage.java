package com.triscent.pages;

import com.triscent.utilities.DriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    private static WebDriver driver;

    private static @FindBy(xpath = "//input[@value='Log in']") WebElement loginButton;
    private @FindBy(name = "Email") WebElement emailTextBox;
    private @FindBy(name = "Password") WebElement passwordTextBox;

    private static String emailId = "";

    private static final String TITLE= "Demo Web Shop. Login";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public static boolean verifyTitle() {
        return TITLE.equals(driver.getTitle());
    }

    public static String getEmailId() {
        return emailId;
    }

    public LoginPage withUsername(String username) {
        CharSequence cs = username;
        emailTextBox.clear();
        emailTextBox.sendKeys(cs);
        emailId = username;
        System.out.println(emailId);
        return this;
    }

    public LoginPage andPassword(String password) {
        CharSequence cs = password;
        passwordTextBox.clear();
        passwordTextBox.sendKeys(cs);
        return this;
    }

    public static void login() {
        loginButton.click();
    }
}