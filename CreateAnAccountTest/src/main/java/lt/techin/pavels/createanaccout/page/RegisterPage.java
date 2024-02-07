package lt.techin.pavels.createanaccout.page;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class RegisterPage extends BasePage implements Register {
    @FindBy(css = "input#email")
    WebElement inputEmail;
    @FindBy(css = "input#name")
    WebElement inputName;
    @FindBy(css = "input#password")
    WebElement inputPassword;
    @FindBy(css = "input#confirmPassword")
    WebElement inputConfirmPassword;
    @FindBy(css = "button[type='submit']")
    WebElement buttonRegisterSubmit;
    @FindBy(xpath = "//div[@class='alert alert-success']/b[text()='User account created successfully']")
    WebElement alertRegisterSuccess;

    @FindBy(xpath = "//div[@class='invalid-feedback']")
    List<WebElement> errorMessages;

    public RegisterPage(WebDriver driver) {
        super(driver);
    }


    @Override
    public void enterEmailAddress(String email) {
        actions.moveToElement(inputEmail).click().sendKeys(email).perform();
    }

    @Override
    public void enterName(String name) {
        inputName.sendKeys(name);
    }

    @Override
    public void enterPassword(String password) {
        inputPassword.sendKeys(password);
    }

    @Override
    public void enterConfirmPassword(String confirmPassword) {
        inputConfirmPassword.sendKeys(confirmPassword);
    }

    @Override
    public void submitRegisterClick() {
        buttonRegisterSubmit.click();
    }

    public boolean isAlertRegisterSuccessVisible() {
        try {
            wait.until(ExpectedConditions.visibilityOf(alertRegisterSuccess));
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    public List<WebElement> getErrorMessages() {
        return errorMessages;
    }

    public boolean isAlertWithTextVisible(String alertMessage) {
//        return alertRegisterSuccess.getText().contains(alertMessage);
        return errorMessages.stream().anyMatch(error -> error.getText().contains(alertMessage));
    }

}
