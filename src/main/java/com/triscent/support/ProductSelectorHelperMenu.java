package com.triscent.support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ProductSelectorHelperMenu {

    private static WebDriver driver;
    private static @FindBy(name = "products-orderby")
    WebElement selectProduct;

    public ProductSelectorHelperMenu(WebDriver driver) {
        this.driver = driver;
    }

    public static void sortBy(SortBy sortBy) {
        System.out.println(sortBy.getValue());
        Select select = new Select(selectProduct);
        select.selectByVisibleText(sortBy.getValue());
    }

}
