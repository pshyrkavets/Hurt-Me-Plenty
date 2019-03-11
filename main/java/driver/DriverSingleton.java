package driver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class DriverSingleton {
    private static WebDriver driver;
    //private static final Logger logger = LogManager.getRootLogger();
    private static final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";
    private static final String CHROMEDRIVER_CHROMEDRIVER_EXE_PATH =
            "C:\\Users\\Pavel_Shyrkavets\\Downloads\\chromedriver_win32\\chromedriver.exe";

    private DriverSingleton(){};

    public static WebDriver getDriver() {
        if (null == driver) {
            System.setProperty(WEBDRIVER_CHROME_DRIVER, CHROMEDRIVER_CHROMEDRIVER_EXE_PATH);
            driver = new ChromeDriver();
            driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            //logger.info("Browser started");
        }

        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}
