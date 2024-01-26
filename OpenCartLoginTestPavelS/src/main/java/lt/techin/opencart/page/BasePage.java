package lt.techin.opencart.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    @FindBy(xpath = "/html//nav[@id='top']/div/div[2]/ul[@class='list-inline']//div/a/span[.='My Account']")
    protected WebElement navMyAccount;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String getPageTitle(){
        return driver.getTitle();
    }
}
