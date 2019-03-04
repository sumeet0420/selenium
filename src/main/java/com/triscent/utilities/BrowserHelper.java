package com.triscent.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class BrowserHelper {

    private static WebDriver driver;

       public static void openLinkInNewTab(WebElement element){
        element.sendKeys(Keys.chord(Keys.CONTROL, Keys.ENTER));
    }

    /*public void scrollToElement(WebElement element) throws InterruptedException {
        Thread.sleep(200);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void scrollTo300() {
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,300)");
    }
*/
    public static void takeScreenShot(WebDriver driver, String fileName){
        LocalDate date = LocalDate.now();
        date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String filePath = System.getProperty("user.dir")+File.separator+"src"+File.separator+"output"+File.separator
                +date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        takeScreenShot(driver, filePath,fileName);
    }

    public static void takeScreenShot(WebDriver driver, String filePath, String fileName){
        TakesScreenshot scrShot =( (TakesScreenshot) driver);
        try {
            File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
            File DestFile=new File(filePath+File.separator+fileName);
            FileUtils.copyFile(SrcFile, DestFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
