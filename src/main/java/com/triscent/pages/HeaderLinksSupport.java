package com.triscent.pages;

import com.triscent.utilities.DriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.triscent.utilities.DriverSetup.isElementPresent;

public class HeaderLinksSupport {

    private static WebDriver driver;
    private static @FindBy(linkText ="Log out" ) WebElement logout;
    private static @FindBy(linkText ="Log in" ) WebElement login;
    private static @FindBy(linkText = "Register") WebElement register;
    private static @FindBy(partialLinkText = "Shopping cart") WebElement shoppingCart;


    public static void clickEmailId() {
        driver.findElement(By.linkText(LoginPage.getEmailId())).click();
    }

    public static boolean verifyUserLoggedIn(){

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
