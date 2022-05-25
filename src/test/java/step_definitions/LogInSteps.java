package step_definitions;

import command_providers.ActOn;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import page_objects.LogIn;
import utilities.ReadConfigFiles;

import java.util.List;
import java.util.Map;


public class LogInSteps {
    WebDriver driver = Hooks.driver;
    private static final Logger LOGGER = LogManager.getLogger(LogInSteps.class);
    @Given("^a user navigates to Account tab$")
    public void aUserIsOnTheLoginPage() {
        ActOn.browser(driver).openBrowser(ReadConfigFiles.getPropertyValues("OverstockUrl"));
        new LogIn(driver)
                .waitForPageToLoad();
        LOGGER.info("User is in the Overstock sign in Page");
    }
    @When("^user enters username \"(.+?)\" and password \"(.+?)\"$")
    public void userEntersUsernameAndPassword(String username, String password) {
        new LogIn(driver)
                .enterEmail(username)
                .enterPassword(password);
        LOGGER.info("User has entered credentials");
    }
    @When("^click on login button$")
    public void clickOnLoginButton() {
        new LogIn(driver)
                .clickOnSignIn();
        LOGGER.info("User has entered successfully");
    }
    @When("user click on login button entering credentials")
    public void userClickOnLoginButtonEnteringCredentials(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        for (Map<String, String> cells: data) {
            new LogIn(driver)
                    .enterEmail(cells.get("username"))
                    .enterPassword(cells.get("password"));
        }
    }
    @Then("^user is navigated to Dashboard$")
    public void userIsNavigatedToDashboard() {
        LOGGER.info("User has landed on Dashboard");
    }
    @Then("^user is failed to login$")
    public void userIsFailedLogin() {
        LOGGER.info("User has failed to land on Dashboard");
    }

}