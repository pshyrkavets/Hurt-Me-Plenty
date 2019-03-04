package com.epam.ta.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComputeEnginePage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    private final String BASE_URL = "https://cloud.google.com/products/calculator/";

    @FindBy(xpath = "//md-tabs-canvas//md-tab-item[1]")
    private WebElement computeEngineButton;

    public ComputeEnginePage(WebDriver driver) {
        super(driver);

    }

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("Login page opened");
    }

    public void clickComputeEngineButton(WebElement element) {
        element.click();
        logger.info("Login performed");
    }

    public WebElement getComputeEngineButton() {
        return computeEngineButton;
    }
}
