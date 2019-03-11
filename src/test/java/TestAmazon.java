import com.epam.ta.pages.AmazonPage;
import driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import stepdefs.AmazonStepDefs;

import java.time.Duration;

public class TestAmazon {
    WebDriver driver = DriverSingleton.getDriver();
    //AmazonPage amazonPage = new AmazonPage(driver);
    AmazonStepDefs amazonStepDefs = new AmazonStepDefs();

    @Test(description = "I opened Amazon site")
    public void openAmazonSite() throws InterruptedException {
        /*System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Pavel_Shyrkavets\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();*/
        amazonStepDefs.iOpenedAmazonSite();
        //amazonPage.openPage();
        //Thread.sleep(5000);
        //new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("a-page")));
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        WebElement aPage = wait.until(driver1 -> driver1.findElement(By.id("a-page")));
        String url = driver.getCurrentUrl();

        Assert.assertEquals(url, "https://www.amazon.com/");
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
