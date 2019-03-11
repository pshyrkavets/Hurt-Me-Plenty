package stepdefs;

import com.epam.ta.pages.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;

public class AmazonStepDefs {

    @Given("I opened Amazon site")
    public void iOpenedAmazonSite() {
        new AmazonPage(DriverSingleton.getDriver()).openPage();
    }

    @When("I search Iphone SE")
    public void iSearchIphoneSE() {
    }

    @And("I open item page")
    public void iOpenItemPage() {
    }

    @Then("Item price is lower than {int}")
    public void itemPriceIsLowerThan(int arg0) {
    }
}
