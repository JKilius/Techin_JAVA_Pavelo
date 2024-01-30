package lt.techin.ToDoList.page;

import org.openqa.selenium.WebElement;

import java.util.List;

public interface ToDo {
    void addNewTask(String titleOfTask);

    List<WebElement> getTaskList();

    void markTaskAsDone(String partOfTaskTitle);

    String getTaskStyleStatus(String partOfTaskTitle);

    void deleteTask(String partOfTaskTitle);

    long getCompletedTaskCount();

    boolean isItemInList(String newTaskTitle);
}
