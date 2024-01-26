package lt.techin.opencart.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyAccountPage extends BasePage {
    @FindBy(xpath = "html//nav[@id='top']/div/div[2]/ul[@class='list-inline']//ul[@class='dropdown" +
            "-menu dropdown-menu-right show']//a[@href='http://192.168.1.117/en-gb?route=account/logout']")
    protected WebElement linkDropDownLogout;

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public void logout() {
        navMyAccount.click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.visibilityOf(linkDropDownLogout));
        if (linkDropDownLogout.isDisplayed()) linkDropDownLogout.click();
    }

}
