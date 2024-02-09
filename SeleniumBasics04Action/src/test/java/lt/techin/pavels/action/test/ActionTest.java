package lt.techin.pavels.action.test;

import lt.techin.pavels.action.ActionPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionTest {
    private WebDriver driver;
    private Actions actions;
    private ActionPage actionPage;

    @BeforeEach
    void setup(){
    driver = new ChromeDriver();
    driver.get("https://webdriveruniversity.com/Actions/index.html");
    actionPage = new ActionPage(driver);

    driver.manage().window().maximize();
    }
    @Test
    void TempTest(){
        actionPage.dragBoxDraggable();
    }
}