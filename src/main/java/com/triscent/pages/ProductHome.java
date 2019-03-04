package com.triscent.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class ProductHome {
    private static WebDriver driver;

    public ProductHome(WebDriver driver) {
        this.driver = driver;
    }

    public static void selectProduct(String product) {
        driver.findElement(By.linkText(product)).click();
    }

    public static List<String> listAllProductNames(){
        List<WebElement> elementList = driver.findElements(By.xpath("//div[@class='item-box']//descendant::h2[@class]/a"));
        return elementList.stream()
                .map(product->product.getText())
                .collect(toList());
    }

    public static List<String> listAllProductPrices(){
        List<WebElement> elementList = driver.findElements(By.xpath("//div[@class='item-box']//descendant::span[@class]"));
        return elementList.stream()
                .map(product->product.getText())
                .collect(toList());
    }
}
