package lt.techin.pavels.action.test;

import lt.techin.pavels.action.ActionPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ActionTest {
    private WebDriver driver;
    private ActionPage actionPage;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.get("https://webdriveruniversity.com/Actions/index.html");
        actionPage = new ActionPage(driver);
        driver.manage().window().maximize();
    }

    @Test
    void clickAndHoldClickBoxTest() {
        // Click and hold clickBox
        actionPage.clickDownClickBox();

        // Set and get expected and actual values of clickBox background color
        String expectedClickBoxBackgroundColor = "rgba(0, 255, 0, 1)";
        String actualClickBoxBackgroundColor = actionPage.getClickBoxBackgroundColor();
        String messageOnColorAssertFail = "Asserting visible background color:";

        // Set and get expected and actual values of clickBox text
        String expectedClickBoxText = "Well done! keep holding that click now.....";
        String actualClickBoxText = actionPage.getClickBoxText();
        String messageOnTextAssertFail = "Expected visible text: Well done! keep holding that click now.....";

        assertEquals(expectedClickBoxBackgroundColor, actualClickBoxBackgroundColor, messageOnColorAssertFail);
        assertEquals(expectedClickBoxText, actualClickBoxText, messageOnTextAssertFail);
    }

    @Test
    void hoverOverButtonsTest() {
        actionPage.mouseMoveOverButtonFirst();
        assertEquals(1, actionPage.getCountOfVisibleSubMenuElements(), "Expected number of visible dropdown elements under first button = 1");

        actionPage.mouseMoveOverButtonSecond();
        assertEquals(1, actionPage.getCountOfVisibleSubMenuElements(), "Expected number of visible dropdown elements under second button = 1");

        actionPage.mouseMoveOverButtonThird();
        assertEquals(2, actionPage.getCountOfVisibleSubMenuElements(), "Expected number of visible dropdown elements under third button = 2");
    }


    @Test
    void doubleClickingBoxTest() {
        // double clicking doubleClick box
        actionPage.doubleClickBoxDoubleClick();

        // set and get expected and actual doubleClickBox background color
        String expectedClickBoxBackgroundColor = "rgba(147, 203, 90, 1)";
        String actualClickBoxBackgroundColor = actionPage.getBoxDoubleClickBackgroundColor();

        // asserting doubleClickBox background color
        assertEquals(expectedClickBoxBackgroundColor, actualClickBoxBackgroundColor, "Asserting doubleClickBox background color:");
    }

    @Test
    void draggingBoxDroppableTest() {
        // drag draggable box on droppable box
        actionPage.dragBoxDraggable();

        // set and get expected and actual values of droppable box background color
        String expectedBoxDroppableBackgroundColor = "rgba(244, 89, 80, 1)";
        String actualBoxDroppableBackgroundColor = actionPage.getBoxDroppableBackgroundColor();


        // expected and actual values of droppable box text
        String expectedBoxDroppableText = "Dropped!";
        String actualBoxDroppableText = actionPage.getBoxDroppableText();

        // asserting droppable box background color and text
        assertEquals(expectedBoxDroppableBackgroundColor, actualBoxDroppableBackgroundColor, "Asserting droppable box background color:");
        assertEquals(expectedBoxDroppableText,actualBoxDroppableText,"Asserting droppable box text:");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}