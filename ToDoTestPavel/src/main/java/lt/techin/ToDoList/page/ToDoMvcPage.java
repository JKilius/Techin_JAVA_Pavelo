package lt.techin.ToDoList.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ToDoMvcPage extends BasePage implements ToDo {

    @FindBy(css = "#todo-input")
    protected WebElement inputAddNewTask;
    @FindBy(xpath = "//ul[@class='todo-list']/li[last()]")
    protected WebElement listTaskLast;
    @FindBy(css = ".todo-list label")
    protected List<WebElement> taskList;

    public ToDoMvcPage(WebDriver webDriver) {
        super(webDriver);
    }


    @Override
    public void addNewTask(String titleOfTask) {
        inputAddNewTask.sendKeys(titleOfTask + Keys.ENTER);
    }

    @Override
    public List<WebElement> getTaskList() {
        return taskList;
    }

    @Override
    public void markTaskAsDone(String partOfTaskTitle) {
        driver.findElement(By.xpath("//*[contains(text(),'" + partOfTaskTitle + "')]/../input")).click();

    }

    @Override
    public String getTaskStyleStatus(String partOfTaskTitle) {
        return driver.findElement(By.xpath("//*[contains(text(),'" + partOfTaskTitle + "')]")).getCssValue("text-decoration");
    }

    @Override
    public void deleteTask(String partOfTaskTitle) {
        actions.moveToElement(driver.findElement(By.xpath("//*[contains(text(),'" + partOfTaskTitle + "')]"))).perform();
        actions.click(driver.findElement(By.xpath("//*[contains(text(),'" + partOfTaskTitle + "')]/../button"))).perform();
    }

    @Override
    public long getCompletedTaskCount() {
        return taskList.stream().filter(x -> x.getCssValue("text-decoration")
                .contains("line-through")).count();
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
