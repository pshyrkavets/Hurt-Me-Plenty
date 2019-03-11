import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import com.epam.ta.pages.ComputeEnginePage;

public class TestFillUpComputeEngineForm {
    static WebDriver driver;


    @Test(description = "Fill Up Number Of Instances")
    public void testFillUpComputeEngineForm() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Pavel_Shyrkavets\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://cloud.google.com/products/calculator/");
        //Thread.sleep(5000);

        driver.switchTo().frame("idIframe");
        WebDriverWait waitst = new WebDriverWait(driver, 20);
        waitst.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=\"input_46\"]")));

        //Number of instances: 4
        WebElement numberOfInstances = driver.findElement(By.xpath("//input[@id=\"input_46\"]"));
        numberOfInstances.sendKeys("4");
        Thread.sleep(5000);

        //Instance type: n1-standard-8    (vCPUs: 8, RAM: 30 GB)
        WebElement instanceType = driver.findElement(By.xpath("//*[@id=\"select_value_label_42\"]"));
        instanceType.click();
        WebElement n1Standard8 = driver.findElement(By.xpath("//*[@id=\"select_option_70\"]/div"));
        n1Standard8.click();
        Thread.sleep(5000);

        //Выбрать Add GPUs
        WebElement addGPUs = driver.findElement(By
                .xpath("//*[@id=\"mainForm\"]/div[1]/div/md-card/md-card-content/div/div[1]/form/div[6]/div[1]/md-input-container/md-checkbox/div[1]"));
        addGPUs.click();
        //Number of GPUs: 1
        WebElement numberOfGPUs = driver.findElement(By
                .xpath("//*[@id=\"select_value_label_327\"]"));
        numberOfGPUs.click();

        WebElement oneGPU = driver.findElement(By
                .xpath("(//div[@class='md-text ng-binding'][contains(.,'1')])[56]"));
                oneGPU.click();

        //GPU type: NVIDIA Tesla V100
        WebElement typeOfGPU = driver.findElement(By
                .xpath("//*[@id=\"select_value_label_328\"]"));
        typeOfGPU.click();
        WebElement typeNVIDIATeslaV100 = driver.findElement(By
                .xpath("//div[@class='md-text ng-binding'][contains(.,'NVIDIA Tesla V100')]"));
        typeNVIDIATeslaV100.click();

        //Local SSD: 2x375 Gb
        WebElement localSSD = driver.findElement(By
                .xpath("//*[@id=\"select_value_label_43\"]"));
        localSSD.click();
        WebElement localSSD2x375 = driver.findElement(By
                .xpath("//*[@id=\"select_option_182\"]/div"));
        localSSD2x375.click();

        //Datacenter location: Frankfurt (europe-west3)
        WebElement location = driver.findElement(By
                .xpath("//*[@id=\"select_value_label_105\"]/span[1]/div"));
        location.click();
        WebElement europeWest3 = driver.findElement(By
                .xpath("//*[@id=\"select_option_230\"]/div"));
        europeWest3.click();

        //Commited usage: 1 Year
        WebElement commitedUsage = driver.findElement(By
                .xpath("//*[@id=\"select_value_label_45\"]"));
        commitedUsage.click();
        WebElement oneYear = driver.findElement(By
                .xpath("//*[@id=\"select_option_100\"]/div"));
        oneYear.click();

        //Нажать Add to Estimate
        WebElement addToEstimate = driver.findElement(By
                .xpath("//*[@id=\"mainForm\"]/div[1]/div/md-card/md-card-content/div/div[1]/form/div[11]/button"));
        addToEstimate.click();

        WebElement emailEstimate = driver.findElement(By
                .xpath("//*[@id=\"email_quote\"]"));

        Assert.assertTrue(emailEstimate.isDisplayed());
    }

    public static void mouseClickByLocator( String cssLocator ) {
        String locator = cssLocator;
        WebElement el = driver.findElement( By.cssSelector( locator ) );
        Actions builder = new Actions(driver);
        builder.moveToElement( el ).click( el );
        builder.perform();
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
