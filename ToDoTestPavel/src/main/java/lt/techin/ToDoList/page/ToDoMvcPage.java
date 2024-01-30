package lt.techin.ToDoList.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ToDoMvcPage extends BasePage {
    public ToDoMvcPage(WebDriver webDriver) {
        super(webDriver);
    }


    @Override
    public void addNewTask(String titleOfTask) {

    }

    @Override
    public List<WebElement> getTaskList() {
        return null;
    }

    @Override
    public void markTaskAsDone(String partOfTaskTitle) {

    }

    @Override
    public String getTaskStyleStatus(String partOfTaskTitle) {
        return null;
    }

    @Override
    public void deleteTask(String partOfTaskTitle) {

    }

    @Override
    public long getCompletedTaskCount() {
        return 0;
    }
}
