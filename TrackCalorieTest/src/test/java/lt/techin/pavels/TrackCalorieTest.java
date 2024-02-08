package lt.techin.pavels;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TrackCalorieTest {
    protected WebDriver driver;
    TrackCaloriePage trackCaloriePage;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        trackCaloriePage = new TrackCaloriePage(driver);
        driver.get("https://practice.expandtesting.com/tracalorie");
        driver.manage().window().maximize();
    }

//    @Test
//    void tempTest() {
//        trackCaloriePage.enterItemName("abc");
//        trackCaloriePage.enterItemCalories(100);
//        trackCaloriePage.clickButtonAddMeal();
////        driver.navigate().refresh();
//        trackCaloriePage.addItem("abcd", 200);
//        trackCaloriePage.getCollectionItemsNames().stream().map(s -> s.split(" ")[0]).forEach(System.out::println);
//        trackCaloriePage.getCollectionItemsNames().stream().map(s -> s.split(" ")[1]).forEach(System.out::println);
//    }


// Tasks to accomplish in Test:

// AddMealTest parameterized

    @ParameterizedTest
    @CsvFileSource(resources = "/testData.csv", numLinesToSkip = 1)
    void addMealTest(String itemName, String itemCalories, boolean expectedResult) {

        // Initial data for assertion
        List<String> collectionItemsNames = trackCaloriePage.getCollectionItemsNames();
        List<String> collectionItemsCalories = trackCaloriePage.getCollectionItemsCalories();
        int collectionSizeBefore = collectionItemsNames.size();
        int numberOfMatchingNamesBefore = (int) collectionItemsNames.stream().filter(i -> i.contains(itemName)).count();
        int numberOfMatchingCaloriesBefore =
                (int) collectionItemsCalories.stream().filter(i -> i.contains(itemCalories)).count();

        // Adding an item
        trackCaloriePage.addItem(itemName, String.valueOf(itemCalories));

        // Data to be compared after adding an item
        collectionItemsNames = trackCaloriePage.getCollectionItemsNames();
        collectionItemsCalories = trackCaloriePage.getCollectionItemsCalories();
        int collectionSizeAfter = collectionItemsNames.size();
        int numberOfMatchingNamesAfter = (int) collectionItemsNames.stream().filter(i -> i.contains(itemName)).count();
        int numberOfMatchingCaloriesAfter =
                (int) collectionItemsCalories.stream().filter(i -> i.contains(itemCalories)).count();

        // Assertions
        if (expectedResult) {
            assertEquals(collectionSizeBefore + 1, collectionSizeAfter, "Expected collection size to increase by 1 after adding item");
            assertEquals(numberOfMatchingNamesBefore + 1, numberOfMatchingNamesAfter, "Expected number of matching names to increase by 1 after adding item");
            assertEquals(numberOfMatchingCaloriesBefore + 1, numberOfMatchingCaloriesAfter, "Expected number of " +
                    "matching calories to increase by 1 after adding item");
        } else {
            assertEquals(collectionSizeBefore, collectionSizeAfter, "Expected collection size to not increase by 1 after adding item");
            assertEquals(numberOfMatchingNamesBefore, numberOfMatchingNamesAfter, "Expected number of matching names to not increase by 1 after adding item");
            assertEquals(numberOfMatchingCaloriesBefore, numberOfMatchingCaloriesAfter, "Expected number of " +
                    "matching calories to increase by 1 after adding item");
        }
    }

    // TotalCaloriesCountingTest
    @Test
    void totalCaloriesCountingTest() {
        int expectedSum = 0;
        int itemCalories = 100;
        for (int i = 1; i < 5; i++) {
            String itemName = "Item" + i;
            trackCaloriePage.addItem(itemName, String.valueOf(itemCalories));
            if (itemCalories > 0) expectedSum += itemCalories;
            itemCalories += 100;
        }
        int totalCalories = trackCaloriePage.getTotalCalories();
        assertEquals(expectedSum, totalCalories);

    }

// EditMealButtonTest
// DeleteMealTest
// ClearAllButtonTest
// BackFromEditButtonTest
// CaloriesUpButtonTest
// CaloriesDownButtonTest

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}