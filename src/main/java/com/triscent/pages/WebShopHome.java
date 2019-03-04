package com.triscent.pages;

import com.triscent.exceptions.LoginError;
import com.triscent.support.ProductType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebShopHome {

    private static WebDriver driver;

    private static final String url = "http://demowebshop.tricentis.com/";
    private static final String TITLE= "Demo Web Shop";

    /*
    Locating all the elements required for Home Page
    */

    private static @FindBy(className="ico-login")  WebElement login;
    private static @FindBy(linkText = "Register") WebElement register;
    private @FindBy(linkText = "Appareals") WebElement apparels;
    private static @FindBy(linkText = "Apparel & Shoes") WebElement books;
    private static @FindBy(linkText = "Apparel & Shoes") WebElement computers;
    private static @FindBy(linkText = "ELECTRONICS") WebElement electronics;
    private static @FindBy(linkText = "Log out") WebElement logout;
    private static boolean isUserLoggedIn;

    public static boolean verifyUserLogin(){
    return isUserLoggedIn;
    }
    public WebShopHome(WebDriver driver) {
        this.driver = driver;
    }

    public static void openWebShopHomePage() {
        driver.get(url);
    }

    public static boolean verifyTitle() {
        return TITLE.equals(driver.getTitle());
    }

    public static void selectProductType(ProductType productType) {
        driver.findElement(By.linkText(productType.category)).click();
    }

    public static void clickLogin(){
        if(logout != null) {
            login.click();
            isUserLoggedIn = true;
        } else {
            new LoginError("A user is already logged in.");
        }
    }
}
