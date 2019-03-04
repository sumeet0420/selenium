package com.triscent.pages;

import com.triscent.support.Gender;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.triscent.utilities.DriverSetup.isElementPresent;

public class RegisterPage {
    private static WebDriver driver;

    private static @FindBy(id = "gender-male") WebElement maleRadioButton;
    private static @FindBy(id = "gender-female") WebElement femaleRadioButton;
    private static @FindBy(name = "FirstName") WebElement firstName;
    private static @FindBy(name = "LastName") WebElement lastName;
    private static @FindBy(name = "Email") WebElement email;
    private static @FindBy(name = "Password") WebElement password;
    private static @FindBy(name = "ConfirmPassword") WebElement confirmPassword;
    private static @FindBy(id="register-button") WebElement registerButton;
    private static @FindBy(className = "result") WebElement result;
    private static @FindBy(xpath = "//span[@for='ConfirmPassword']") WebElement passwordNotMatch;
    private static final String TITLE= "Demo Web Shop. Register";

    public boolean verifyTitle(){
        return TITLE.equals(driver.getTitle());
    }

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public static void clickRegisterButton(){
        registerButton.click();
    }

    public static String getErrorMessageForPasswordMatch(){
        return passwordNotMatch.getText();
    }

    public static void selectGender(Gender gender){
        if (gender.name().equals("MALE")) {
            maleRadioButton.click();
        } else if (gender.name().equals("FEMALE")) {
            femaleRadioButton.click();
        }
    }

    public static void selectGender(String gender){
        if (gender.equalsIgnoreCase("MALE")) {
            maleRadioButton.click();
        } else if (gender.equalsIgnoreCase("FEMALE")) {
            femaleRadioButton.click();
        }
    }

    public static void enterFirstName(String firstName){
        RegisterPage.firstName.sendKeys(firstName);
    }

    public static void enterLastName(String lastName){
        RegisterPage.lastName.sendKeys(lastName);
    }

    public static void enterEmail(String email){
        RegisterPage.email.sendKeys(email);
    }

    public static void enterPassword(String password){
        RegisterPage.password.sendKeys(password);
    }

    public static void enterConfirmPassword(String repassword){
        RegisterPage.confirmPassword.sendKeys(repassword);
    }

    public static boolean verifyRegister(){
            WebDriverWait wait = new WebDriverWait(driver,5);
            wait.until(ExpectedConditions.visibilityOf(result));
            isElementPresent(result);
            return  result.getText().equals("Your registration completed");
    }
}
