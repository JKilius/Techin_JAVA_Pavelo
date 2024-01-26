package lt.techin.opencart.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {
    @FindBy(css = "#input-email")
    protected WebElement inputEmail;

    @FindBy(css = "#input-password")
    protected WebElement inputPassword;

    @FindBy(xpath = "//form[@id='form-login']//button[@type='submit']")
    protected WebElement buttonLogin;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmail(String email) {
        inputEmail.sendKeys(email);
    }

    public String getInputEmailValue() {
        return inputEmail.getAttribute("value");
    }

    public String getInputPasswordValue() {
        return inputPassword.getAttribute("value");
    }

    public void enterPassword(String password) {
        inputPassword.sendKeys(password);
    }
    public void clickButtonLogin (){
        buttonLogin.click();
    }
    public void login (String email, String password){
        HomePage homePage = new HomePage(driver);
        homePage.clickNavMyAccount();
        homePage.clickLinkDropDownLogin();
        enterEmail(email);
        enterPassword(password);
        clickButtonLogin();
    }
}
