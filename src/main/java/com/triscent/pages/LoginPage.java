package com.triscent.pages;

import com.triscent.utilities.DriverSetup;
import com.triscent.utilities.LogUtility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.triscent.utilities.LogUtility.log;

public class LoginPage {

    private static WebDriver driver;

    private static @FindBy(xpath = "//input[@value='Log in']") WebElement loginButton;
    private @FindBy(name = "Email") WebElement emailTextBox;
    private @FindBy(name = "Password") WebElement passwordTextBox;
    private static String emailId = "";
    /*private static @FindBy(css = "span.field-validation-error") WebElement emailIDError;
    private static @FindBy(css = "span.validation-summary-errors") WebElement validationSummary;*/
    private static boolean userLoggedInFlag = false;
    private static final String TITLE = "Demo Web Shop. Login";

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
        log.info("User " + username + " tried to login.");
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
        /*if (emailIDError.getText().equals("Please enter a valid email address."))
            userLoggedInFlag = false;
        else if (validationSummary.getText() != null)
            userLoggedInFlag = false;
        else
            userLoggedInFlag = true;*/
    }
}