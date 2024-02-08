package lt.techin.pavels;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.stream.IntStream;

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

// Tasks to accomplish in Test:

    // AddMealTest parameterized
    @ParameterizedTest
    @CsvFileSource(resources = "/testData.csv", numLinesToSkip = 1)
    void addMealTest(String itemName, String itemCalories, boolean expectedResult) {

        // Initial data for assertion
        int collectionSizeBefore = trackCaloriePage.collectionSize();
        int numberOfMatchingNamesBefore = trackCaloriePage.numberOfMatchingNames(itemName);

        // Adding an item
        trackCaloriePage.addItem(itemName, String.valueOf(itemCalories));

        // Data to be compared after adding an item
        int collectionSizeAfter = trackCaloriePage.collectionSize();
        int numberOfMatchingNamesAfter = trackCaloriePage.numberOfMatchingNames(itemName);

        // Assertions
        if (expectedResult) {
            assertEquals(collectionSizeBefore + 1, collectionSizeAfter, "Expected collection size to increase by 1 " +
                    "after adding an item");
            assertEquals(numberOfMatchingNamesBefore + 1, numberOfMatchingNamesAfter, "Expected number of matching " +
                    "names to increase by 1 after adding an item");
        } else {
            assertEquals(collectionSizeBefore, collectionSizeAfter, "Expected collection size to not increase by 1 " +
                    "after adding an item");
            assertEquals(numberOfMatchingNamesBefore, numberOfMatchingNamesAfter, "Expected number of matching names " +
                    "to not increase by 1 after adding an item");
        }
    }

    // TotalCaloriesCountingTest
    @Test
    void totalCaloriesCountingTest() {
        int expectedSum = 400;
        int itemCalories = 100;

        // Adding 4 items
        IntStream.rangeClosed(1, 4).forEach(i -> {
            String itemName = "Item" + i;
            trackCaloriePage.addItem(itemName, String.valueOf(itemCalories));
        });
//        for (int i = 1; i < 5; i++) {
//            String itemName = "Item" + i;
//            trackCaloriePage.addItem(itemName, String.valueOf(itemCalories));
//        }

        // Getting Total calories
        int totalCalories = trackCaloriePage.getTotalCalories();

        // Asserting if Total Calories equal to the sum of inputted calories
        assertEquals(expectedSum, totalCalories, "Expected for Total Calories to be equal to the sum of inputted calories");
    }

    // ClearAllButtonTest
    @Test
    void buttonClearAllTest() {
        // Adding items to be deleted
        String itemName = "itemName";
        String itemCalories = "100";
        trackCaloriePage.addItem(itemName, itemCalories);
        trackCaloriePage.addItem(itemName, itemCalories);
        trackCaloriePage.addItem(itemName, itemCalories);

        // Getting collection size before clear all
        int collectionSizeBefore = trackCaloriePage.collectionSize();

        // Clearing all collection
        trackCaloriePage.clickButtonClearAll();

        // Getting collection size after clear all
        int collectionSizeAfter = trackCaloriePage.collectionSize();

        // Asserting if collection is empty
        assertTrue(collectionSizeBefore > 0, "Expected to collection size to be > 0");
        assertEquals(0, collectionSizeAfter, "Expected collection size to be = 0");
    }

    // EditMealButtonTest
    @Test
    void editMealButtonTest() {
        String itemName = "itemName";
        String itemCalories = "100";
        trackCaloriePage.addItem(itemName, itemCalories);
        trackCaloriePage.clickButtonEditMeal(itemName);
        assertTrue(trackCaloriePage.isButtonUpdateMealVisible(), "Expected for Update Meal button to be visible");
    }

    // DeleteMealTest
    @Test
    void deleteMealTest() {
        // Adding an item
        String itemName = "itemName";
        String itemCalories = "100";
        trackCaloriePage.addItem(itemName, itemCalories);

        // Initial data for assertion
        int collectionSizeBefore = trackCaloriePage.collectionSize();
        int numberOfMatchingNamesBefore = trackCaloriePage.numberOfMatchingNames(itemName);

        // Deleting item
        trackCaloriePage.clickButtonEditMeal(itemName);
        trackCaloriePage.clickButtonDeleteMeal();

        // Data to be compared after deleting an item
        int collectionSizeAfter = trackCaloriePage.collectionSize();
        int numberOfMatchingNamesAfter = trackCaloriePage.numberOfMatchingNames(itemName);

        // Assertions
        assertEquals(collectionSizeBefore - 1, collectionSizeAfter, "Expected collection size to decrease by 1 " +
                "after deleting an item");
        assertEquals(numberOfMatchingNamesBefore - 1, numberOfMatchingNamesAfter, "Expected number of matching " +
                "names to decrease by 1 after deleting an item");
    }
// BackFromEditButtonTest
// CaloriesUpButtonTest
// CaloriesDownButtonTest

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}