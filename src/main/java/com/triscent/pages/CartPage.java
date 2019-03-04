package com.triscent.pages;

import org.openqa.selenium.By;
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
    private static @FindBy(name = "checkout") WebElement checkoutButton;
    private static @FindBy(name = "termsofservice") WebElement termsCheckBox;
    private static @FindBy(name = "updatecart") WebElement updateCart;

    public CartPage(WebDriver driver) {
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
            Thread.sleep(100);
            return true;
        } else {
            throw new Exception("Product Not Found");
        }
    }

    public static List<WebElement> getAllCartItems(){
        return driver.findElements(By.xpath("//input[@name='removefromcart']"));
    }

    public static boolean emptyCart() {
        List<WebElement> cartItemCheckBox = getAllCartItems();

        if (cartItemCheckBox.size() > 0) {
            try {
            cartItemCheckBox.forEach(product -> product.click());
            updateCart.click();
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return true;
        } else {
            return false;
        }
    }
}