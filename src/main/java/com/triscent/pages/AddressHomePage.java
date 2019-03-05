package com.triscent.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class AddressHomePage {

    private static @FindBy(xpath = "//input[@value='Add new']") WebElement addNewButton;
    private static WebDriver driver;

    private static @FindBy(xpath = "//input[@value='Edit']") WebElement edit;
    private static @FindBy(xpath = "//input[@value='Delete']") WebElement delete;

    public AddressHomePage(WebDriver driver){
        this.driver = driver;
    }
    public static void clickAddNewAddressButton(){
        addNewButton.click();
    }

    public static int noOfAddresses(){
        return driver.findElements(By.cssSelector("div[class='section address-item']")).size();
    }
    public static void deleteAddress(int addressNumber){
        driver.findElements(By.xpath("//input[@value='Delete']")).get(addressNumber-1).click();
        driver.switchTo().alert().accept();
    }

    public static void editAddress(int addressNumber){
        driver.findElements(By.xpath("//input[@value='Edit']["+addressNumber+"]")).get(addressNumber-1).click();
        driver.switchTo().alert().accept();
    }
}
