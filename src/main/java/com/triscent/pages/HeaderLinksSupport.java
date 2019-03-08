package com.triscent.pages;

import com.triscent.utilities.DriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.triscent.utilities.DriverSetup.isElementPresent;

public class HeaderLinksSupport {

    private static String emailId= LoginPage.getEmailId();
    private static WebDriver driver;
    private static @FindBy(linkText ="Log out" ) WebElement logout;
    private static @FindBy(linkText ="Log in" ) WebElement login;
    private static @FindBy(linkText = "Register") WebElement register;
    private static @FindBy(partialLinkText = "Shopping cart") WebElement shoppingCart;

    public HeaderLinksSupport(WebDriver driver){
    this.driver = driver;
    }

    public static void clickEmailId() {
        driver.findElement(By.linkText(LoginPage.getEmailId())).click();
    }

    public static boolean verifyUserLoggedIn(){
        System.out.println(By.linkText(LoginPage.getEmailId()));
        return (isElementPresent(By.linkText(LoginPage.getEmailId())));
    }

    public static void clickLogout(){
        if(!isElementPresent(logout))
        logout.click();
    }

    public static void clickLogin() {
        login.click();
    }

    public static void clickShoppingCartButton(){
        shoppingCart.click();
    }

    public static void clickRegister() {
        register.click();
    }
}
