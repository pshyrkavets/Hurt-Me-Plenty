import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.List;

public class TestActivateComputeEngine {
    //*[@id="top_of_page"]/div//a[]
    WebDriver driver;
    @Test
    public void testActivateComputeEngine() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "C:\\webdriver\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://cloud.google.com/products/calculator/");

        List<WebElement> elements = driver.findElements
                (By.xpath("//*[@id=\"top_of_page\"]/div//a[@track-metadata-eventdetail='compute']"));


        driver.get(elements.get(0).getAttribute("href"));

        Thread.sleep(5000);
        String url = driver.getCurrentUrl();

        Assert.assertEquals(url, "https://cloud.google.com/compute/");
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
