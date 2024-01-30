package lt.techin.ToDoList.test;

import lt.techin.ToDoList.page.ToDoListPageWebdriveruniversity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ToDoListTest {

    protected WebDriver driver;
    protected ToDoListPageWebdriveruniversity toDoListPage;


    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.get("https://webdriveruniversity.com/To-Do-List/index.html");
        driver.manage().window().maximize();
        toDoListPage = new ToDoListPageWebdriveruniversity(driver);
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

        String partOfTaskTitle = "new robes";
        toDoListPage.markTaskAsDone(partOfTaskTitle);

        long completedTasksAfter = toDoListPage.getCompletedTaskCount();
        assertTrue(toDoListPage.getTaskStyleStatus(partOfTaskTitle).contains("line-through"));
        assertEquals(completedTasksBefore + 1, completedTasksAfter);
    }

    @Test
    void deleteTask() {
        String partOfTaskTitle = "new robes";
        toDoListPage.getTaskList();
        toDoListPage.deleteTask(partOfTaskTitle);

    }
}
