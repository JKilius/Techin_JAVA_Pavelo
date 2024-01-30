package lt.techin.ToDoList.test;

import lt.techin.ToDoList.page.ToDo;
import lt.techin.ToDoList.page.ToDoWebdriPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

public class ToDoListTest {

    protected WebDriver driver;
    protected ToDo toDoListPage;


    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.get("https://webdriveruniversity.com/To-Do-List/index.html");
//        driver.get("https://todomvc.com/examples/react/dist/");
        toDoListPage = new ToDoWebdriPage(driver);
//        toDoListPage = new ToDoMvcPage(driver);
        driver.manage().window().maximize();
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
        String lastTaskText = toDoListPage.getLastTaskText();
        assertEquals(listSizeBefore + 1, listSizeAfter);
        assertEquals(newTaskTitle, lastTaskText);
    }

    @Test
    void markTaskAsDoneTest() {
        long completedTasksBefore = toDoListPage.getCompletedTaskCount();
        String newTaskTitle = "Papasakoti apie Jėzų Kristų";
        toDoListPage.addNewTask(newTaskTitle);
        toDoListPage.markTaskAsDone(newTaskTitle);
        long completedTasksAfter = toDoListPage.getCompletedTaskCount();
        assertTrue(toDoListPage.isTaskCompleted(newTaskTitle));
        assertEquals(completedTasksBefore + 1, completedTasksAfter);
    }

    @Test
    void deleteTask() {
        String newTaskTitle = "Papasakoti apie Jėzų Kristų";
        toDoListPage.addNewTask(newTaskTitle);
        int taskListSizeBefore = toDoListPage.getTaskListSize();
        toDoListPage.deleteTask(newTaskTitle);
        int taskListSizeAfter = toDoListPage.getTaskListSize();
        assertEquals(taskListSizeBefore - 1, taskListSizeAfter);
        assertFalse(toDoListPage.isItemInList(newTaskTitle));
    }
}
