package com.triscent.pages;

import static com.triscent.utilities.BrowserHelper.wakeUpAfter;
import static com.triscent.utilities.LogUtility.log;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static com.triscent.utilities.DriverSetup.isElementPresent;

public class CartPage {
    private static WebDriver driver;

    private static final String TITLE = "Demo Web Shop. Shopping Cart";
    private static @FindBy(name = "checkout")
    WebElement checkoutButton;
    private static @FindBy(name = "termsofservice")
    WebElement termsCheckBox;
    private static @FindBy(name = "updatecart")
    WebElement updateCart;
    private static @FindBys(@FindBy(xpath = "//input[@name='removefromcart']"))
    List<WebElement> productList;
    private static @FindBy(name = "discountcouponcode")
    WebElement discountTextBox;
    private static @FindBy(name = "applydiscountcouponcode")
    WebElement applyDiscountCodeButton;
    //private static @FindBy(css = "div.message") WebElement message;
    private static @FindBy(name = "removediscountcouponcode")
    WebElement removeDiscountCodeButton;
    private static final String successfulDiscountCodeMessage = "The coupon code was applied";

    public CartPage(WebDriver driver) {
        if (driver == null)
            log.error("Driver is null as Cart Page");
        this.driver = driver;
    }

    public static boolean verifyTitle() {
        return TITLE.equals(driver.getTitle());
    }

    public static void checkTermsAndConditions() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(termsCheckBox));
        termsCheckBox.click();
    }

    public static void checkout() {
        checkoutButton.click();
    }

    public static boolean removeItem(String productName) throws Exception {
        String xpath = "//*[text()='" + productName + "' and @class='product-name']/ancestor::td/preceding-sibling::td[@class='remove-from-cart']";
        boolean checkProduct = isElementPresent(By.xpath(xpath));
        if (checkProduct) {
            driver.findElement(By.xpath(xpath + "/input[@name='removefromcart']")).click();
            updateCart.click();
            wakeUpAfter(100);
            return true;
        } else {
            log.info("Invalid Product. Product not found.");
            throw new Exception("Product Not Found");
        }
    }

    public static List<WebElement> getAllCartItems() {
        return productList;
    }

    public static boolean emptyCart() {
        List<WebElement> cartItemCheckBox = getAllCartItems();

        if (cartItemCheckBox.size() > 0) {
                cartItemCheckBox.forEach(product -> product.click());
                updateCart.click();
                wakeUpAfter(200);
            return true;
        } else {
            return false;
        }
    }

    public static void applyDiscountCode(String discountCode) {
        discountTextBox.clear();
        discountTextBox.sendKeys(discountCode);
        applyDiscountCodeButton.click();
    }

    public static void removeDiscountCode() {
        removeDiscountCodeButton.click();
    }

    public static boolean verifyDiscountCode() {
        By messageBox = By.cssSelector("div.message");
           if(!isElementPresent(messageBox))
               return false;
        if (driver.findElement(messageBox).getText().equals(successfulDiscountCodeMessage))
            return true;
        else
            return false;
    }
}