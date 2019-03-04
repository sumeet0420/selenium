package com.triscent.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderProduct {

    private static WebDriver driver;

    private static @FindBy(className = "qty-input") WebElement quantity;
    private static @FindBy(xpath = "//div[@class='add-to-cart-panel']/input[@value='Add to cart']") WebElement addToCart;
    private static @FindBy(xpath = "//*[@itemprop='price']") WebElement price;

    public OrderProduct(WebDriver driver) {
        this.driver = driver;
    }

    public static void setQuantity(int quantity) {
        OrderProduct.quantity.clear();
        OrderProduct.quantity.sendKeys(String.valueOf(quantity));
    }

    public static String getPrice() {
        return price.getText();
    }

    public static void addToCart() {
        addToCart.click();
    }
}
