import com.triscent.pages.WebShopHome;
import com.triscent.support.ProductType;
import org.testng.annotations.Test;

import static com.triscent.pages.WebShopHome.openWebShopHomePage;
import static com.triscent.pages.WebShopHome.selectProductType;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestAllProductCategory extends BaseTest {

    @Test(description = "Test Product Books")
    public void testBooks() {
        openWebShopHomePage();
        assertTrue(WebShopHome.verifyTitle());
        selectProductType(ProductType.BOOKS);
        assertEquals(driver.getCurrentUrl(), ProductType.BOOKS.URL());
    }

    @Test(description = "Test Product Computer Desktops")
    public void testDesktop() {
        openWebShopHomePage();
        assertTrue(WebShopHome.verifyTitle());
        selectProductType(ProductType.COMPUTERS.DESKTOPS);
        assertEquals(driver.getCurrentUrl(), ProductType.COMPUTERS.DESKTOPS.URL());
    }

    @Test(description = "Test Product Computer Notebooks")
    public void testNotebooks() {
        openWebShopHomePage();
        assertTrue(WebShopHome.verifyTitle());
        selectProductType(ProductType.COMPUTERS.NOTEBOOKS);
        assertEquals(driver.getCurrentUrl(), ProductType.COMPUTERS.NOTEBOOKS.URL());
    }

    @Test(description = "Test Product Computer Accessories")
    public void testAccessories() {
        openWebShopHomePage();
        assertTrue(WebShopHome.verifyTitle());
        selectProductType(ProductType.COMPUTERS.ACCESSORIES);
        assertEquals(driver.getCurrentUrl(), ProductType.COMPUTERS.ACCESSORIES.URL());
    }

    @Test(description = "Test Product Electronics Camera")
    public void testCamera() {
        openWebShopHomePage();
        assertTrue(WebShopHome.verifyTitle());
        selectProductType(ProductType.ELECTONICS.CAMERA);
        assertEquals(driver.getCurrentUrl(), ProductType.ELECTONICS.CAMERA.URL());
    }

    @Test(description = "Test Product Electronics Cell Phones")
    public void testCellphones() {
        openWebShopHomePage();
        assertTrue(WebShopHome.verifyTitle());
        selectProductType(ProductType.ELECTONICS.CELLPHONES);
        assertEquals(driver.getCurrentUrl(), ProductType.ELECTONICS.CELLPHONES.URL());
    }

    @Test(description = "Test Product Apparels and Shoes")
    public void testApparels() {
        openWebShopHomePage();
        assertTrue(WebShopHome.verifyTitle());
        selectProductType(ProductType.APPARELS);
        assertEquals(driver.getCurrentUrl(), ProductType.APPARELS.URL());
    }

    @Test(description = "Test Product Digital Downloads")
    public void testDigitalDownloads() {
        openWebShopHomePage();
        assertTrue(WebShopHome.verifyTitle());
        selectProductType(ProductType.DIGITAL_DOWNLOADS);
        assertEquals(driver.getCurrentUrl(), ProductType.DIGITAL_DOWNLOADS.URL());
    }

    @Test(description = "Test Product Digital Downloads")
    public void testJewelry() {
        openWebShopHomePage();
        assertTrue(WebShopHome.verifyTitle());
        selectProductType(ProductType.JEWELRY);
        assertEquals(driver.getCurrentUrl(), ProductType.JEWELRY.URL());
    }

    @Test(description = "Test Product Gift Cards")
    public void testGiftCards() {
        openWebShopHomePage();
        assertTrue(WebShopHome.verifyTitle());
        selectProductType(ProductType.GIFT_CARDS);
        assertEquals(driver.getCurrentUrl(), ProductType.GIFT_CARDS.URL());
    }

}