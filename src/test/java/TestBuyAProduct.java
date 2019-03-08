import com.triscent.pages.*;
import com.triscent.support.ProductType;
import com.triscent.support.SortBy;
import org.testng.annotations.Test;

import static com.triscent.pages.CartPage.checkTermsAndConditions;
import static com.triscent.pages.CartPage.checkout;
import static com.triscent.pages.CheckoutPage.*;
import static com.triscent.pages.HeaderLinksSupport.clickShoppingCartButton;
import static com.triscent.pages.HeaderLinksSupport.verifyUserLoggedIn;
import static com.triscent.pages.OrderProduct.addToCart;
import static com.triscent.pages.OrderProduct.setQuantity;
import static com.triscent.pages.ProductHome.selectProduct;
import static com.triscent.pages.WebShopHome.openWebShopHomePage;
import static com.triscent.pages.WebShopHome.selectProductType;
import static com.triscent.support.ProductSelectorHelperMenu.sortBy;
import static org.testng.Assert.assertTrue;

public class TestBuyAProduct extends BaseTest{

    @Test(description = "To test the order functionality end-to-end")
    public void testOrderAPrdoduct(){
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
        checkTermsAndConditions();
        checkout();
        selectBillingAddressByIndex(0);
        clickBillingAddressContinueButton();
        clickShippingAddressContinueButton();
        selectShippingMethod(ShippingMethod.ONE_DAY_AIR);
        clickShippingMethodContinueButton();
        selectPaymentMethod(PaymentMethod.CREDITCARD);
        clickPaymentMethodContinueButton();
        CreditCardPayment.selectCreditCardType(CreditCardPayment.CreditCardType.AMEX);
        CreditCardPayment.sendCardHolderName("ABCDEF");
        CreditCardPayment.sendCardNumber("12341234123");
        CreditCardPayment.selectExpiryYear("2020");
        CreditCardPayment.selectExpiryMonth("03");
        CreditCardPayment.sendCardCode("1234");
        clickPaymentInformationContinueButton();
        clickConfirmOrderContinueButton();
    }
}
