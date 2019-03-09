import com.triscent.pages.*;
import com.triscent.support.ProductSelectorHelperMenu;
import com.triscent.utilities.BrowserHelper;
import com.triscent.utilities.DriverSetup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static com.triscent.pages.WebShopHome.openWebShopHomePage;
import static com.triscent.utilities.DriverSetup.quitBrowser;
import static org.testng.Assert.assertTrue;

/*
*This is a base test class. It will initialize setups for drivers as well as invoke all the Page Object Class with the help of PageFactory Selenium Class.
 */

public class BaseTest {

    protected WebDriver driver ;
    protected LoginPage loginPage;
    protected static final String username = UserDetailsPropertiesLoad.getUserName();
    protected static final String password = UserDetailsPropertiesLoad.getPassword();

    @BeforeSuite
    public void setUpSuite(){
        driver = DriverSetup.openChrome();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        PageFactory.initElements(driver, WebShopHome.class);
        PageFactory.initElements(driver, MyAccountOptions.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        PageFactory.initElements(driver, ProductHome.class);
        PageFactory.initElements(driver, OrderProduct.class);
        PageFactory.initElements(driver, CartPage.class);
        PageFactory.initElements(driver, HeaderLinksSupport.class);
        PageFactory.initElements(driver, ProductSelectorHelperMenu.class);
        PageFactory.initElements(driver, RegisterPage.class);
        PageFactory.initElements(driver, BrowserHelper.class);
        PageFactory.initElements(driver,AddressAddPage.class);
        PageFactory.initElements(driver,AddressHomePage.class);
        PageFactory.initElements(driver, CheckoutPage.class);
        PageFactory.initElements(driver, CreditCardPayment.class);
    }

    /*
    *The purpose of the following test is verify whether the browser is opening and the homepage is successfullly getting opened.
     */

    @Test//(enabled = false)
    public void test(){
        openWebShopHomePage();
        assertTrue(WebShopHome.verifyTitle());
    }

   @AfterSuite
    public void cleanUp(){
        quitBrowser();
    }
}