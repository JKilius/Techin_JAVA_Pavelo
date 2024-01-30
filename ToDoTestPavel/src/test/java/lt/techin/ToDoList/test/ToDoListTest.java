package lt.techin.ToDoList.test;

import lt.techin.ToDoList.page.ToDo;
import lt.techin.ToDoList.page.ToDoListPageWebdriveruniversity;
import lt.techin.ToDoList.page.ToDoMvcPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

public class ToDoListTest {

    protected WebDriver driver;
    protected ToDo toDoListPage;


    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
//        driver.get("https://webdriveruniversity.com/To-Do-List/index.html");
        driver.get("https://todomvc.com/examples/react/dist/");

        driver.manage().window().maximize();
//        toDoListPage = new ToDoListPageWebdriveruniversity(driver);
        toDoListPage = new ToDoMvcPage(driver);

    }

    @AfterEach
    void driverQuit() {
        driver.quit();
    }

    @Test
    void addNewTask() {
        String newTaskTitle = "Papasakoti apie Jėzų Kristų";
        int listSizeBefore = toDoListPage.getTaskList().size();
        toDoListPage.addNewTask(newTaskTitle);
        int listSizeAfter = toDoListPage.getTaskList().size();
        String lastElementText = toDoListPage.getTaskList().getLast().getText();
        assertEquals(listSizeBefore + 1, listSizeAfter);
        assertEquals(newTaskTitle, lastElementText);
    }

    @Test
    void markTaskAsDoneTest() {
        long completedTasksBefore = toDoListPage.getCompletedTaskCount();
        String newTaskTitle = "Papasakoti apie Jėzų Kristų";
        toDoListPage.addNewTask(newTaskTitle);
        toDoListPage.markTaskAsDone(newTaskTitle);

        long completedTasksAfter = toDoListPage.getCompletedTaskCount();
        assertTrue(toDoListPage.getTaskStyleStatus(newTaskTitle).contains("line-through"));
        assertEquals(completedTasksBefore + 1, completedTasksAfter);
    }

    @Test
    void deleteTask() {
        String newTaskTitle = "Papasakoti apie Jėzų Kristų";
        toDoListPage.addNewTask(newTaskTitle);
        int taskListSizeBefore = toDoListPage.getTaskList().size();
        toDoListPage.deleteTask(newTaskTitle);
        int taskListSizeAfter = toDoListPage.getTaskList().size();
        assertEquals(taskListSizeBefore - 1, taskListSizeAfter);
        assertFalse(toDoListPage.isItemInList(newTaskTitle));
    }
}
