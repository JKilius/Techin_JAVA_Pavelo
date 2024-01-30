package lt.techin.ToDoList.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ToDoListPageWebdriveruniversity extends BasePage implements ToDo {


    @FindBy(xpath = "//input[@type='text']")
    protected WebElement inputAddNewTask;
    @FindBy(xpath = "//li[1]")
    protected WebElement listTask1;

    @FindBy(xpath = "//li[last()]")
    protected WebElement listTaskLast;

    @FindBy(xpath = "//li")
    protected List<WebElement> taskList;

    public ToDoListPageWebdriveruniversity(WebDriver webDriver) {
        super(webDriver);
    }


    public void addNewTask(String titleOfTask) {
        inputAddNewTask.sendKeys(titleOfTask + Keys.ENTER);
    }

    public List<WebElement> getTaskList() {
        return taskList;
    }

    public void markTaskAsDone(String partOfTaskTitle) {
        wait.until(ExpectedConditions.visibilityOf(listTask1));
        driver.findElement(By.xpath("//*[contains(text(),'" + partOfTaskTitle + "')]")).click();
    }

    public String getTaskStyleStatus(String partOfTaskTitle) {
        return driver.findElement(By.xpath("//*[contains(text(),'" + partOfTaskTitle + "')]")).getCssValue("text-decoration");
    }

    public long getCompletedTaskCount() {
        return taskList.stream().filter(x -> x.getCssValue("text-decoration")
                .contains("line-through")).count();
    }

    public void deleteTask(String partOfTaskTitle) {
        actions.moveToElement(driver.findElement(By.xpath("//*[contains(text(),'" + partOfTaskTitle + "')]"))).perform();
        actions.click(driver.findElement(By.xpath("//*[contains(text(),'" + partOfTaskTitle + "')]/span/i"))).perform();
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//*[contains(text(),'" + partOfTaskTitle + "')]"))));
    }

    @Override
    public boolean isItemInList(String newTaskTitle) {
        return taskList.stream().map(WebElement::getText).anyMatch(text -> text.contains(newTaskTitle));
    }

    @Override
    public int getTaskListSize() {
        return taskList.size();
    }

    @Override
    public String getLastTaskText() {
        return listTaskLast.getText();
    }
}
