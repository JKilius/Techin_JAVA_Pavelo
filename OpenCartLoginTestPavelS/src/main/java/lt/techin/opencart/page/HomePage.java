package lt.techin.opencart.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {


    @FindBy(xpath = "/html//nav[@id='top']/div/div[2]/ul[@class='list-inline']//ul[@class='dropdown" +
            "-menu dropdown-menu-right show']//a[@href='http://192.168.1.117/en-gb?route=account/login']")
    protected WebElement linkDropDownLogin;

//@FindBy()
//private WebElement

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickNavMyAccount() {
        navMyAccount.click();
    }

    public boolean isLinkDropDownLoginDisplayed() {
        return linkDropDownLogin.isDisplayed();
    }

    public void clickLinkDropDownLogin() {
        linkDropDownLogin.click();
    }


}
