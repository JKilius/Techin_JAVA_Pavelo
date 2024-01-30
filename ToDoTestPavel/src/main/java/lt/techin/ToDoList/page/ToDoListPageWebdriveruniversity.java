package lt.techin.ToDoList.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ToDoListPageWebdriveruniversity extends BasePage{


    @FindBy(xpath = "//input[@type='text']")
    protected WebElement inputAddNewTask;
    @FindBy(xpath = "//li[1]")
    protected WebElement li1;

    public ToDoListPageWebdriveruniversity(WebDriver webDriver) {
        super(webDriver);
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
    }
    public String getTaskStyleStatus(String partOfTaskTitle){
        return driver.findElement(By.xpath("//*[contains(text(),'"+partOfTaskTitle+"')]")).getCssValue("text-decoration");
    }
    public long getCompletedTaskCount(){
        return driver.findElements(By.xpath("//li")).stream().filter(x -> x.getCssValue("text-decoration")
                .contains("line-through")).count();
    }

    public void deleteTask (String partOfTaskTitle){
        actions.moveToElement(driver.findElement(By.xpath("//*[contains(text(),'"+partOfTaskTitle+"')]"))).perform();
        actions.click(driver.findElement(By.xpath("//*[contains(text(),'"+partOfTaskTitle+"')]/span/i"))).perform();


    }


}
