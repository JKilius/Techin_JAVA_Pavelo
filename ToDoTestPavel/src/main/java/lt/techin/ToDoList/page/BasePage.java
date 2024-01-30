package lt.techin.ToDoList.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class BasePage implements ToDo {
    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;

    public BasePage(WebDriver webDriver) {
        this.driver = webDriver;
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
}
