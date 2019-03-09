package com.triscent.pages;

import static com.triscent.utilities.LogUtility.log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class AddressAddPage {

    private static final String TITLE= "Demo Web Shop. Account";
    private static final String URL = "http://demowebshop.tricentis.com/customer/addressadd";

    private static @FindBy(name = "Address.FirstName") WebElement firstName;
    private static @FindBy(name = "Address.LastName") WebElement lastName;
    private static @FindBy(name = "Address.Email") WebElement email;
    private static @FindBy(name = "Address.Company") WebElement company;
    private static @FindBy(name = "Address.CountryId") WebElement country;
    private static @FindBy(name="Address.StateProvinceId") WebElement state;
    private static @FindBy(name="Address.City") WebElement city;
    private static @FindBy(name="Address.Address1") WebElement addressLine1;
    private static @FindBy(name="Address.Address2") WebElement addressLine2;
    private static @FindBy(name="Address.ZipPostalCode") WebElement postalCode;
    private static @FindBy(name="Address.PhoneNumber") WebElement phoneNumber;
    private static @FindBy(name="Address.FaxNumber") WebElement faxNumber;
    private static @FindBy(xpath="//input[@type='submit' and @value='Save']") WebElement saveButton;
    private static WebDriver driver;

    public AddressAddPage(WebDriver driver) {
    AddressAddPage.driver = driver;
    }

    public static void setFirstName(String firstName) {
        AddressAddPage.firstName.clear();
        AddressAddPage.firstName.sendKeys(firstName);
        log.info("First Name set as "+firstName);
    }

    public static void setLastName(String lastName) {
        AddressAddPage.lastName.clear();
        AddressAddPage.lastName.sendKeys(lastName);
        log.info("Last Name set as "+lastName);
    }

    public static void setEmail(String email) {
        AddressAddPage.email.clear();
        AddressAddPage.email.sendKeys(email);
        log.info("Email set as "+email);
    }

    public static void setCompany(String company) {
        AddressAddPage.company.clear();
        AddressAddPage.company.sendKeys(company);
        log.info("Company Name Set as "+company);
    }

    public static void setCountry(String country) {
        Select  select = new Select(AddressAddPage.country);
        select.selectByVisibleText(country);
        log.info("Country set as "+country);
    }

    public static void setState(String state) {
        Select  select = new Select(AddressAddPage.state);
        select.selectByVisibleText(state);
        log.info("State set as "+state);
    }

    public static void setCity(String city) {
        AddressAddPage.city.clear();
        AddressAddPage.city.sendKeys(city);
        log.info("City set as "+city);
    }

    public static void setAddressLine1(String addressLine1) {
        AddressAddPage.addressLine1.clear();
        AddressAddPage.addressLine1.sendKeys(addressLine1);
        log.info("Address Line 1 set as "+addressLine1);
    }

    public static void setAddressLine2(String addressLine2) {
        AddressAddPage.addressLine2.clear();
        AddressAddPage.addressLine2.sendKeys(addressLine2);
        log.info("Address Line 2 set as "+addressLine2);

    }

    public static void setPostalCode(String postalCode) {
        AddressAddPage.postalCode.clear();
        AddressAddPage.postalCode.sendKeys(postalCode);
        log.info("Postal Code set as "+postalCode);
    }

    public static void setPhoneNumber(String phoneNumber) {
        AddressAddPage.phoneNumber.clear();
        AddressAddPage.phoneNumber.sendKeys(phoneNumber);
        log.info("Phone Number set as"+phoneNumber);
    }

    public static void setFaxNumber(String faxNumber) {
        AddressAddPage.faxNumber.clear();
        AddressAddPage.faxNumber.sendKeys(faxNumber);
        log.info("Fax Number set as "+faxNumber);
    }

    public static void clickSaveButton() {
        AddressAddPage.saveButton.click();
        log.info("Saved button clicked.");
    }
}
