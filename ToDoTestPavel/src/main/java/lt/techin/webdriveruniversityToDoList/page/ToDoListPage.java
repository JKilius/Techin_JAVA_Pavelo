package lt.techin.webdriveruniversityToDoList.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ToDoListPage {
   protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;
    @FindBy(xpath = "//input[@type='text']")
    protected WebElement inputAddNewTask;
    @FindBy(xpath = "//li[1]")
    protected WebElement li1;
    public ToDoListPage(WebDriver webDriver) {
        this.driver = webDriver;
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void addNewTask(String titleOfTask) {
        inputAddNewTask.sendKeys(titleOfTask + Keys.ENTER);
    }

    public List<WebElement> getTaskList() {
        return driver.findElements(By.xpath("//li"));
    }
    public void markTaskAsDone (String partOfTaskTitle){
        wait.until(ExpectedConditions.visibilityOf(li1));
        driver.findElement(By.xpath("//*[contains(text(),'"+partOfTaskTitle+"')]")).click();
//        driver.findElement(By.xpath("//*[contains(text(), 'new robes')]"));
        //*[contains(text(),'Part of Your Text')]
//        li1.click();
    }
    public String getTaskStatus (String partOfTaskTitle){
        return driver.findElement(By.xpath("//*[contains(text(),'"+partOfTaskTitle+"')]")).getCssValue("text-decoration");
    }

    public void deleteTask (String partOfTaskTitle){
        actions.moveToElement(driver.findElement(By.xpath("//*[contains(text(),'"+partOfTaskTitle+"')]"))).perform();
        actions.click(driver.findElement(By.xpath("//*[contains(text(),'"+partOfTaskTitle+"')]/span/i"))).perform();


    }


}
