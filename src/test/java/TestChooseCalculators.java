import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import java.util.List;

public class TestChooseCalculators {
    WebDriver driver;
    @Test
    public void testCalculators() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "C:\\webdriver\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://cloud.google.com/pricing/");

        List<WebElement> elements = driver.findElements
                (By.xpath("//a[contains(.,'Calculators') and @track-name='pricingNav/calculators']"));

        driver.get(elements.get(0).getAttribute("href"));

        Thread.sleep(5000);
        String url = driver.getCurrentUrl();

        Assert.assertEquals(url, "https://cloud.google.com/products/calculator/");
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
