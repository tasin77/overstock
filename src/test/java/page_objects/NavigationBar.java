package page_objects;

import command_providers.ActOn;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationBar {
    private final By PopUp = By.xpath("//*[@class='cl-icon cl-dialog-close-icon']");
    private final By AccountLink  = By.name("Account");
    public WebDriver driver;

    public NavigationBar(WebDriver driver) {
        this.driver = driver;
    }

    public NavigationBar waitForPopUp() {
        ActOn.wait(driver, PopUp).waitForElementToBeVisible();
        return this;
    }

    public NavigationBar closePopUp() {
        ActOn.element(driver, PopUp).click();
        return this;
    }

    public NavigationBar clickOnAccount() {
        ActOn.element(driver, AccountLink).click();
        return this;
    }
}
