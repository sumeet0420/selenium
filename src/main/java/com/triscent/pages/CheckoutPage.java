package com.triscent.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.triscent.utilities.LogUtility.log;

public class CheckoutPage {

    private static WebDriver driver;
    private static @FindBy(name = "billing_address_id") WebElement selectBillingAddress;
    private static @FindBy(name = "shipping_address_id") WebElement selectShipingAddress;
    private static @FindBy(id = "shippingoption_0") WebElement radioButtonGround;
    private static @FindBy(id = "shippingoption_1") WebElement radioButtonNextDayAir;
    private static @FindBy(id = "shippingoption_2") WebElement radioButton2ndDay;
    private static @FindBy(id = "paymentmethod_0") WebElement radioCOD;
    private static @FindBy(id = "paymentmethod_1") WebElement radioCheck;
    private static @FindBy(id = "paymentmethod_2") WebElement radioCreditCard;
    private static @FindBy(id = "paymentmethod_3") WebElement radioPurchaseOrder;
    private static @FindBy(xpath = "//input[@onclick='Billing.save()']") WebElement continueBillingAddressButton;
    private static @FindBy(xpath = "//input[@onclick='Shipping.save()']") WebElement continueShippingAddressButton;
    private static @FindBy(xpath = "//input[@onclick='ShippingMethod.save()']") WebElement continueShippingMethodButton;
    private static @FindBy(xpath = "//input[@onclick='PaymentMethod.save()']") WebElement continuePaymentMethodButton;
    private static @FindBy(xpath = "//input[@onclick='PaymentInfo.save()']") WebElement continuePaymentInformationButton;
    private static @FindBy(xpath = "//input[@onclick='ConfirmOrder.save()']") WebElement continueConfirmOrderButton;


    private static @FindBy(linkText = "Back") WebElement backButton;

    public CheckoutPage(WebDriver driver) {
        if (driver == null)
            log.error("driver object is null at Checkout Page");
        this.driver = driver;
    }

    public static void selectBillingAddressByValue(String address) {
        Select select = new Select(selectBillingAddress);
        select.selectByVisibleText(address);
    }

    /*
     *@param int index begins from '0'
     */

    public static void selectBillingAddressByIndex(int index) {
        Select select = new Select(selectBillingAddress);
        select.selectByIndex(index);
    }

    public static void selectShippingingAddressByValue(String address) {
        Select select = new Select(selectBillingAddress);
        select.selectByVisibleText(address);
    }

    /*
     *@param int index begins from '0'
     */

    public static void selectShippingAddressByIndex(int index) {
        Select select = new Select(selectBillingAddress);
        select.selectByIndex(index);
    }

    public static void selectShippingMethod(ShippingMethod shippingMethod) {
        if (shippingMethod.name().equals("GROUND"))
            radioButtonGround.click();
        else if (shippingMethod.name().equals("ONE_DAY_AIR"))
            radioButtonNextDayAir.click();
        else if (shippingMethod.name().equals("TWO_DAY_AIR"))
            radioButton2ndDay.click();
    }

    public static void selectPaymentMethod(PaymentMethod paymentMethod) {
        if (paymentMethod.name().equals("COD"))
            radioCOD.click();
        else if (paymentMethod.name().equals("CHECK"))
            radioCheck.click();
        else if (paymentMethod.name().equals("CREDITCARD"))
            radioCreditCard.click();
        else if (paymentMethod.name().equals("PURCHASEORDER"))
            radioPurchaseOrder.click();
    }

    public static void clickBackButton() {
        backButton.click();
    }

    public static void clickBillingAddressContinueButton() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@onclick='Billing.save()']")));
        continueBillingAddressButton.click();
    }

    public static void clickShippingAddressContinueButton() {
        try {
            Thread.sleep(1000);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@onclick='Shipping.save()']")));
        continueShippingAddressButton.click();
        } catch (InterruptedException e) {
           e.printStackTrace();
        }
    }

    public static void clickShippingMethodContinueButton() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@onclick='ShippingMethod.save()']")));
        continueShippingMethodButton.click();
    }

    public static void clickPaymentMethodContinueButton() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@onclick='PaymentMethod.save()']")));
        continuePaymentMethodButton.click();
    }

    public static void clickPaymentInformationContinueButton() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@onclick='PaymentInfo.save()']")));
        continuePaymentInformationButton.click();
    }

    public static void clickConfirmOrderContinueButton() {
        try {
            Thread.sleep(1000);
            continueConfirmOrderButton.click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
