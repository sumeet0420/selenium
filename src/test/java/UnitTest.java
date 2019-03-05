import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/*
The purpose of this class is to run independependents tests. It doesn't extend the BaseTest for this purpose.
 */
public class UnitTest {
    WebDriver driver;

    @BeforeTest
    public  void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.indiatoday.in/");
    }

    @Test
    public void testing(){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollBy(0,1000)");
        javascriptExecutor.executeScript("window.scrollBy(0,1000)");
    }
}
