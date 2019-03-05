package com.triscent.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountOptions {

    private WebDriver driver;

    private static @FindBy(linkText = "Customer info") WebElement customerInfo;
    private static @FindBy(linkText = "Addresses") WebElement addresses;
    private static @FindBy(linkText = "Orders") WebElement orders;
    private static @FindBy(linkText = "Downloadable products") WebElement download_products;
    private static @FindBy(linkText = "Back in stock subscriptions") WebElement backinstock;
    private static @FindBy(linkText = "Reward points") WebElement rewardPointd;
    private static @FindBy(linkText = "Change password") WebElement changePassword;

    public MyAccountOptions(WebDriver driver) {
        this.driver = driver;
    }

    public static void clickAddresses(){
        addresses.click();
    }

}

