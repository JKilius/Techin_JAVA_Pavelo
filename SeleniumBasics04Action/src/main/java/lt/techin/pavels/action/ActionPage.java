package lt.techin.pavels.action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActionPage {
    private WebDriver driver;
    private Actions actions;
    private WebDriverWait wait;

    @FindBy(css = "#draggable")
    WebElement boxDraggable;
    @FindBy(css = "#droppable")
    WebElement boxDroppable;

    public ActionPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
//        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void dragBoxDraggable() {
        actions.dragAndDrop(boxDraggable, boxDroppable).perform();
    }
}
