package lt.techin.pavels.loginpage;

import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class LoginPage {
    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;
    @FindBy (css = "input[name='username']")
    WebElement inputUserName;
    @FindBy (css = "input[name='password']")
    WebElement inputPassword;
    @FindBy (css = "[class='oxd-sheet oxd-sheet--rounded oxd-sheet--gutters oxd-sheet--gray-lighten-2 " +
            "orangehrm-demo-credentials'] .oxd-text--p:nth-of-type(1)")
    WebElement locationUserName;
    @FindBy (css ="[class='oxd-sheet oxd-sheet--rounded oxd-sheet--gutters oxd-sheet--gray-lighten-2 orangehrm-demo-credentials'] .oxd-text--p:nth-of-type(2)")
    WebElement locationPassword;
    @FindBy (css = ".oxd-alert-content-text")
    WebElement alertText;
    @FindBy (css =".orangehrm-login-title")
    WebElement titleLogin;




    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(titleLogin));
    }

    public void enterUserName(String userName) {
        inputUserName.sendKeys(userName);
    }

    public void enterPassword(String password) {
        inputPassword.sendKeys(password+ Keys.ENTER);
    }

    public String getPageUrl() {
        return driver.getCurrentUrl();
    }

    public String getUserName() {
        String str = locationUserName.getText();
        String[] parts = str.split(": ");
        return parts[1];
    }

    public String getPassword() {
        String str = locationPassword.getText();
        String[] parts = str.split(": ");
        return parts[1];
    }

    public boolean isCredentialAlerTrue() {
        wait.until(ExpectedConditions.visibilityOf(alertText));
        return alertText.isDisplayed();
    }


}
