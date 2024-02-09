package lt.techin.pavels.action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ActionPage {
    private WebDriver driver;
    private Actions actions;
    private WebDriverWait wait;

    @FindBy(css = "#draggable")
    WebElement boxDraggable;
    @FindBy(css = "#droppable")
    WebElement boxDroppable;
    @FindBy(css = "#droppable p")
    WebElement boxDroppableBackgroundColorHolder;
    @FindBy(css = "#double-click")
    WebElement boxDoubleClick;
    @FindBy(xpath = "//button[@class=\"dropbtn\"][text()='Hover Over Me First!']")
    WebElement buttonHoverOverFirst;
    @FindBy(xpath = "//button[@class=\"dropbtn\"][text()='Hover Over Me Second!']")
    WebElement buttonHoverOverSecond;
    @FindBy(xpath = "//button[@class=\"dropbtn\"][text()='Hover Over Me Third!']")
    WebElement buttonHoverOverThird;
    @FindBy(css = ".dropdown-content a")
    List<WebElement> dropDownElements;
    @FindBy (css = "#click-box")
    WebElement clickBox;


    public ActionPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
//        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void dragBoxDraggable() {
        actions.dragAndDrop(boxDraggable, boxDroppable).perform();
    }

    public String getBoxDroppableBackgroundColor() {
        return boxDroppableBackgroundColorHolder.getCssValue("background-color");
    }

    public String getBoxDroppableText() {
        return boxDroppable.getText();
    }
    public void doubleClickBoxDoubleClick(){
        actions.doubleClick(boxDoubleClick).perform();
    }

    public String getBoxDoubleClickBackgroundColor(){
        return boxDoubleClick.getCssValue("background-color");
    }
    public void mouseMoveOverButtonFirst(){
        actions.moveToElement(buttonHoverOverFirst).perform();
    }
    public void mouseMoveOverButtonSecond(){
        actions.moveToElement(buttonHoverOverSecond).perform();
    }
    public void mouseMoveOverButtonThird(){
        actions.moveToElement(buttonHoverOverThird).perform();
    }

    public int getCountOfVisibleSubMenuElements() {
       return (int) dropDownElements.stream().filter(WebElement::isDisplayed).count();
    }

    public void clickDownClickBox() {
        actions.clickAndHold(clickBox).perform();
    }

    public String getClickBoxBackgroundColor() {
       return clickBox.getCssValue("background-color");
    }

    public String getClickBoxText() {
        return clickBox.getText();
    }

}
