import com.triscent.pages.RegisterPage;
import com.triscent.pages.WebShopHome;
import com.triscent.support.Gender;
import org.testng.annotations.Test;

import static com.triscent.pages.HeaderLinksSupport.clickRegister;
import static com.triscent.pages.RegisterPage.*;
import static com.triscent.pages.WebShopHome.openWebShopHomePage;
import static org.testng.Assert.assertTrue;

public class TestRegister extends BaseTest{

    @Test
    public static void testRegisterPage(){
        openWebShopHomePage();
        assertTrue(WebShopHome.verifyTitle());
        clickRegister();
        selectGender(Gender.MALE);
        enterFirstName("SA");
        enterLastName("asa");
        enterEmail("opo187@email.com");
        enterPassword("popopo");
        enterConfirmPassword("popopo");
        clickRegisterButton();
        assertTrue(RegisterPage.verifyRegister());
    }
}
