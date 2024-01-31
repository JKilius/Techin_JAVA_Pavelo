package lt.techin.pavels.loginpage;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountPage {
    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;
    @FindBy(css =".orangehrm-login-title")
    WebElement titleLogin;
    @FindBy (css=".oxd-userdropdown-name")
    WebElement dropDownUser;
    @FindBy (linkText = "Logout")
    WebElement linkLogout;
    public AccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public boolean isLoginTrue() {
        try {
            wait = new WebDriverWait(driver,Duration.ofSeconds(3));
            wait.until(ExpectedConditions.visibilityOf(dropDownUser));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void logOut() {
        dropDownUser.click();
        wait.until(ExpectedConditions.visibilityOf(linkLogout));
        linkLogout.click();
    }
}
