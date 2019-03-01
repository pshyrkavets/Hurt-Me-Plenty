import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.w3c.dom.xpath.XPathResult;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TestExploreAllProductsButton {
    WebDriver driver;
    @Test
    public void testExploreAllProductsButton() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pavel_Shyrkavets\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://cloud.google.com/");

        JavascriptExecutor js = (JavascriptExecutor) driver;


        //js.executeScript("$('a[href=\"https://cloud.google.com/products/\"]').click()");
        //$(document).ready(function() {
        List<WebElement> element = driver.findElements(By.xpath("//div/a[@href='https://cloud.google.com/products/']"));
        element.get(0).click();

        Thread.sleep(5000);
        String url = driver.getCurrentUrl();


        Assert.assertEquals(url, "https://cloud.google.com/products/");
    }

    @AfterClass
    public void afterClass() {
        // Quit the google Chrome driver.
        if(driver != null)
        {
            driver.quit();
            driver = null;
        }
    }
}
