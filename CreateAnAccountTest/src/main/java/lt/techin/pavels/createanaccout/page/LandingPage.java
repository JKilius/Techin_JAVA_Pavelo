package lt.techin.pavels.createanaccout.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends BasePage {

    @FindBy(css = "a[href='/notes/app/login']")
    WebElement linkLogin;
    @FindBy (css = "a[href='/notes/app/register']")
    WebElement linkCreateAnAccount;

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    public void linkLoginClick() {
        actions.click(linkLogin).perform();
    }
    public void linkCreateAnAccountClick(){
        actions.click(linkCreateAnAccount).perform();
    }

}
