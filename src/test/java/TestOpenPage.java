import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class TestOpenPage {
    @Test
    public void testOpenPage() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pavel_Shyrkavets\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://cloud.google.com/");
        List<WebElement> element = driver.findElements(By.xpath("//*[contains(text(), 'https://cloud.google.com/')]"));
        driver.quit();
        Assert.assertTrue(element.get(0) != null);
    }
}
