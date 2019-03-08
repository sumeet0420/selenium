import com.triscent.pages.HeaderLinksSupport;
import com.triscent.pages.LoginPage;
import com.triscent.pages.MyAccountOptions;
import com.triscent.pages.WebShopHome;
import com.triscent.utilities.CSVUtils;
import com.triscent.utilities.DriverSetup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static com.triscent.pages.HeaderLinksSupport.clickLogout;
import static com.triscent.pages.HeaderLinksSupport.verifyUserLoggedIn;
import static com.triscent.pages.WebShopHome.openWebShopHomePage;
import static com.triscent.utilities.DriverSetup.quitBrowser;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class TestDDTUserDetails {//extends BaseTest {
    WebDriver driver;
    LoginPage loginPage;

    @BeforeClass
    public void hell(){
        driver = DriverSetup.openChrome();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        PageFactory.initElements(driver, WebShopHome.class);
        PageFactory.initElements(driver, MyAccountOptions.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        PageFactory.initElements(driver, HeaderLinksSupport.class);
        openWebShopHomePage();
    }

    @BeforeTest
    public void waitFor(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @DataProvider(name = "userdetails")
    public Object[][] userDetails() {
        return CSVUtils.readCSV("userdetails.csv");
    }

    @Test(dataProvider = "userdetails")
    public void testLogin(String username, String password, String expected) {
        assertTrue(WebShopHome.verifyTitle());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        HeaderLinksSupport.clickLogin();
        loginPage.withUsername(username).andPassword(password).login();
        boolean result = Boolean.parseBoolean(expected);
        if (result)
            assertTrue(verifyUserLoggedIn());
        else
            assertFalse(verifyUserLoggedIn());
        clickLogout();
    }

    @AfterTest
    public void cleanUp() {

        //quitBrowser();
    }
}