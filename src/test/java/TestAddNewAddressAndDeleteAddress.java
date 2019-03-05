import com.triscent.pages.*;
import org.testng.annotations.Test;

import static com.triscent.pages.AddressAddPage.*;
import static com.triscent.pages.AddressHomePage.clickAddNewAddressButton;
import static com.triscent.pages.AddressHomePage.deleteAddress;
import static com.triscent.pages.AddressHomePage.noOfAddresses;
import static com.triscent.pages.HeaderLinksSupport.clickEmailId;
import static com.triscent.pages.HeaderLinksSupport.verifyUserLoggedIn;
import static com.triscent.pages.MyAccountOptions.clickAddresses;
import static com.triscent.pages.WebShopHome.openWebShopHomePage;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestAddNewAddressAndDeleteAddress extends BaseTest {

    @Test
    public void testNewAddress() {
        openWebShopHomePage();
        assertTrue(WebShopHome.verifyTitle());
        HeaderLinksSupport.clickLogin();
        loginPage.withUsername(username).andPassword(password).login();
        assertTrue(verifyUserLoggedIn());
        clickEmailId();
        clickAddresses();
        clickAddNewAddressButton();
        setFirstName("First");
        setLastName("Last");
        setEmail("email@email.com");
        setCompany("ABC");
        setCountry("India");
        setCity("City");
        setAddressLine1("Address Line 1");
        setAddressLine2("Address Line 2");
        setPostalCode("Post Code");
        setPhoneNumber("123456789");
        setFaxNumber("12345");
        clickSaveButton();
        try {
            Thread.sleep(100);
            assertEquals(2, noOfAddresses());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clickAddresses();
        deleteAddress(2);
        try {
            Thread.sleep(100);
            assertEquals(1, noOfAddresses());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}