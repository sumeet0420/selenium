package com.triscent.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.triscent.utilities.LogUtility.log;
public class OrderConfirmPage {

    private static final String URL ="http://demowebshop.tricentis.com/checkout/completed/";
    private static final String TITLE = "Demo Web Shop. Checkout";
    private static @FindBy(tagName = "strong") WebElement successfulMessage;
    private static @FindBy(xpath = "//input[@value='Continue']") WebElement continueButton;

    public static boolean verifySuccessfulMessage(){
        if(successfulMessage.getText().equals("Your order has been successfully processed!"))
            log.info("Order placed successfully.");
        else log.error("Order not placed yet or not successful.");
        return successfulMessage.getText().equals("Your order has been successfully processed!");
    }

    public static void clickContiniueButton(){
    continueButton.click();
    }
}
