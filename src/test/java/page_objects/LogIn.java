package page_objects;

import command_providers.ActOn;
import command_providers.AssertThat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogIn extends NavigationBar{

    private final By SignInTab = By.xpath("//*[@id='login-form']");
    private final By Email = By.id("login-email");
    private final By Password = By.id("login-password");
    private final By SignIn = By.xpath("//*[@id='login-form']/button");
    private final By Dashboard = By.xpath("//*[contains(@title,'Dashboard')]");
    private static final Logger LOGGER = LogManager.getLogger(LogIn.class);

    public LogIn(WebDriver driver) {
        super(driver);
    }

    public LogIn waitForPageToLoad() {
        ActOn.wait(driver, SignInTab).waitForElementToBeVisible();
        LOGGER.debug("Wait for tab to be visible");
        return this;
    }

    public LogIn clickOnEmail() {
        ActOn.element(driver, Email).click();
        LOGGER.debug("User has clicked on Email button");
        return this;
    }
    public LogIn enterEmail(String email) {
        ActOn.element(driver, Email).setValue(email);
        LOGGER.debug("Enter Email: " + email);
        return this;
    }

    public LogIn enterPassword(String password) {
        ActOn.element(driver, Password).setValue(password);
        LOGGER.debug("Enter Password: " + password);
        return this;
    }

    public LogIn clickOnSignIn() {
        ActOn.element(driver, SignIn).click();
        LOGGER.debug("Click on Sign In Button");
        return this;
    }
    public LogIn waitForDash() {
        ActOn.wait(driver, Dashboard).waitForElementToBeVisible();
        return this;
    }

    public LogIn validateDashboard() {
        AssertThat.elementAssertions(driver, Dashboard).elementIsDisplayed();
        LOGGER.debug("Dashboard is visible");
        return this;
    }
}