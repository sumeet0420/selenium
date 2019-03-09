import com.triscent.pages.*;
import com.triscent.support.ProductType;
import com.triscent.support.SortBy;
import org.testng.annotations.Test;

import static com.triscent.pages.CartPage.*;
import static com.triscent.pages.CheckoutPage.*;
import static com.triscent.pages.CheckoutPage.clickConfirmOrderContinueButton;
import static com.triscent.pages.CheckoutPage.clickPaymentInformationContinueButton;
import static com.triscent.pages.CreditCardPayment.*;
import static com.triscent.pages.CreditCardPayment.selectExpiryMonth;
import static com.triscent.pages.CreditCardPayment.sendCardCode;
import static com.triscent.pages.HeaderLinksSupport.clickShoppingCartButton;
import static com.triscent.pages.HeaderLinksSupport.verifyUserLoggedIn;
import static com.triscent.pages.OrderConfirmPage.clickContiniueButton;
import static com.triscent.pages.OrderConfirmPage.verifySuccessfulMessage;
import static com.triscent.pages.OrderProduct.addToCart;
import static com.triscent.pages.OrderProduct.setQuantity;
import static com.triscent.pages.ProductHome.selectProduct;
import static com.triscent.pages.WebShopHome.openWebShopHomePage;
import static com.triscent.pages.WebShopHome.selectProductType;
import static com.triscent.support.ProductSelectorHelperMenu.sortBy;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class TestDiscountFunctionality extends BaseTest{

    @Test(description = "To test the discount functionality")
    public void testDiscount(){
        openWebShopHomePage();
        assertTrue(WebShopHome.verifyTitle());
        HeaderLinksSupport.clickLogin();
        loginPage.withUsername(username).andPassword(password).login();
        assertTrue (verifyUserLoggedIn());
        selectProductType(ProductType.APPARELS);
        sortBy(SortBy.priceByAscending);
        selectProduct("Casual Golf Belt");
        setQuantity(4);
        addToCart();
        clickShoppingCartButton();
        applyDiscountCode("AutomatiDiscount2");
        assertFalse(verifyDiscountCode());
        applyDiscountCode("AutomationDiscount2");
        assertTrue(verifyDiscountCode());
        checkTermsAndConditions();
        checkout();
        selectBillingAddressByIndex(0);
        clickBillingAddressContinueButton();
        clickShippingAddressContinueButton();
        selectShippingMethod(ShippingMethod.ONE_DAY_AIR);
        clickShippingMethodContinueButton();
        selectPaymentMethod(PaymentMethod.CREDITCARD);
        clickPaymentMethodContinueButton();
        selectCreditCardType(CreditCardPayment.CreditCardType.AMEX);
        sendCardHolderName("ABCDEF");
        sendCardNumber("12341234123");
        selectExpiryYear("2020");
        selectExpiryMonth("03");
        sendCardCode("1234");
        clickPaymentInformationContinueButton();
        clickConfirmOrderContinueButton();
        verifySuccessfulMessage();
        clickContiniueButton();
    }
}
