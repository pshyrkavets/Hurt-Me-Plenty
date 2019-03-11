package com.epam.ta.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComputeEnginePage extends AbstractPage {
    //private final Logger logger = LogManager.getRootLogger();
    private final String BASE_URL = "https://cloud.google.com/products/calculator/";
    WebDriver driver;

    @FindBy(xpath = "//md-tabs-canvas//md-tab-item[1]")
    private WebElement computeEngineButton;

    @FindBy(xpath = "//input[@id=\"input_46\"]")
    private WebElement numberOfInstances;

    @FindBy(xpath = "//*[@id=\"select_value_label_42\"]")
    private WebElement instanceType;

    public ComputeEnginePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
        //logger.info("Compute Engine page opened");
    }

    public void clickComputeEngineButton(WebElement element) {
        element.click();
        //logger.info("Compute Engine performed");
    }

    public WebElement getComputeEngineButton() {
        return computeEngineButton;
    }

    public WebElement getNumberOfInstances() { return numberOfInstances; }
}
