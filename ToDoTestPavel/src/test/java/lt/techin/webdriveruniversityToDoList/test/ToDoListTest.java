package lt.techin.webdriveruniversityToDoList.test;

import lt.techin.webdriveruniversityToDoList.page.ToDoListPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ToDoListTest {

    protected WebDriver driver;
    protected ToDoListPage toDoListPage;


    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.get("https://webdriveruniversity.com/To-Do-List/index.html");
        driver.manage().window().maximize();
        toDoListPage = new ToDoListPage(driver);
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
        long completedTasksBefore =
                toDoListPage.getTaskList().stream().filter(x -> x.getCssValue("text-decoration")
                        .contains("line-through")).count();

        String partOfTaskTitle = "new robes";
        toDoListPage.markTaskAsDone(partOfTaskTitle);

        long completedTasksAfter =
                toDoListPage.getTaskList().stream().filter(x -> x.getCssValue("text-decoration")
                        .contains("line-through")).count();
        assertTrue(toDoListPage.getTaskStatus(partOfTaskTitle).contains("line-through"));
        assertEquals(completedTasksBefore + 1, completedTasksAfter);
    }

    @Test
    void deleteTask() {
        String partOfTaskTitle = "new robes";
        toDoListPage.getTaskList();
        toDoListPage.deleteTask(partOfTaskTitle);

    }
}
