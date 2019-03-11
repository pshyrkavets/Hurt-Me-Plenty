package com.epam.ta.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AmazonPage extends AbstractPage {
    //private final Logger logger = LogManager.getRootLogger();
    private final String BASE_URL = "https://www.amazon.com/";

    public AmazonPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
        //logger.info("Amazon page opened");
    }
}
