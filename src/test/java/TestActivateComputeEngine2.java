import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import com.epam.ta.pages.ComputeEnginePage;

public class TestActivateComputeEngine2 {
    static WebDriver driver;
    ComputeEnginePage computeEnginePage = PageFactory.initElements(this.driver, ComputeEnginePage.class);

    @Test(description = "Activate Compute Engine")
    public void testActivateComputeEngine2() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Pavel_Shyrkavets\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://cloud.google.com/products/calculator/");
        Thread.sleep(5000);
        computeEnginePage.getComputeEngineButton();
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
