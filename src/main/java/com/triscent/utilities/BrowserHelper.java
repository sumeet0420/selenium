package com.triscent.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BrowserHelper {

    private static WebDriver driver;

       public static void openLinkInNewTab(WebElement element){
        element.sendKeys(Keys.chord(Keys.CONTROL, Keys.ENTER));
    }

    public void scrollToElement(WebElement element) throws InterruptedException {
        Thread.sleep(200);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

   public static void scrollTo300Vertically() {
        scrollBy(0, 300);
    }

    public static void scrollBy(int horizontalPixels, int verticalPixels){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollBy("+horizontalPixels+","+verticalPixels+")");
    }

    public static void takeScreenShot(WebDriver driver, String fileName){
        LocalDate date = LocalDate.now();
        String filePath = System.getProperty("user.dir")+File.separator+"src"+File.separator+"output"+File.separator +
                date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
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