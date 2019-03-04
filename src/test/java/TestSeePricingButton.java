import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.List;

public class TestSeePricingButton {
    WebDriver driver;
    @Test
    public void testExploreAllProductsButton() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pavel_Shyrkavets\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://cloud.google.com/products/");

        List<WebElement> element = driver.findElements(By.xpath("//div/a[@href='https://cloud.google.com/pricing/']"));
        element.get(0).click();

        Thread.sleep(5000);
        String url = driver.getCurrentUrl();


        Assert.assertEquals(url, "https://cloud.google.com/pricing/");
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
