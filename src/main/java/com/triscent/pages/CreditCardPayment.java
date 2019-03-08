package com.triscent.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CreditCardPayment{

    private static WebDriver driver;

    public enum CreditCardType{
        VISA("Visa"), MASTERCARD("Master Card"), DISCOVER("Discover"), AMEX("Amex");

        private String value;

        CreditCardType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
    private static @FindBy(name = "CreditCardType") WebElement selectCreditCardType;
    private static @FindBy(name = "CardholderName") WebElement cardholderName;
    private static @FindBy(name = "CardNumber") WebElement cardNumber;
    private static @FindBy(name = "CardCode") WebElement cardCode;
    private static @FindBy(name = "ExpireMonth") WebElement expireMonth;
    private static @FindBy(name = "ExpireYear") WebElement expireYear;

    public static void selectCreditCardType(CreditCardType creditCardType){
        Select select = new Select(selectCreditCardType);
        select.selectByVisibleText(creditCardType.value);
    }


    public static void sendCardHolderName(String cardHolderName){
        CreditCardPayment.cardholderName.sendKeys(cardHolderName);
    }

    public static void sendCardNumber(String cardNumber){
        CreditCardPayment.cardNumber.sendKeys(cardNumber);
    }

    public static void selectExpiryMonth(String month){
        try {
        int num = Integer.parseInt(month);
        if(num<0||num>12)
                throw new Exception("Invalid Month");
            } catch (Exception e) {
                e.printStackTrace();
            }
        Select select = new Select(expireMonth);
        select.selectByVisibleText(month);
    }

    public static void selectExpiryYear(String year){
        Select select = new Select(expireYear);
        select.selectByVisibleText(year);
    }

    public static void sendCardCode(String code){
        cardCode.sendKeys(code);
    }
}