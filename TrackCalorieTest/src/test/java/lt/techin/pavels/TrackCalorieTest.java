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

        // Adding 4 items and counting sum
        for (int i = 1; i < 5; i++) {
            String itemName = "Item" + i;
            trackCaloriePage.addItem(itemName, String.valueOf(itemCalories));
            if (itemCalories > 0) expectedSum += itemCalories;
            itemCalories += 100;
        }

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
        List<String> collectionItemsNames = trackCaloriePage.getCollectionItemsNames();
        int collectionSizeBefore = collectionItemsNames.size();

        // Clearing all collection
        trackCaloriePage.clickButtonClearAll();

        // Getting collection size after clear all
        collectionItemsNames = trackCaloriePage.getCollectionItemsNames();
        int collectionSizeAfter = collectionItemsNames.size();

        // Asserting if collection is empty
        assertTrue(collectionSizeBefore > 0, "Expected to collection size to be > 0");
        assertEquals(0, collectionSizeAfter, "Expected collection size to be = 0");
    }

        // EditMealButtonTest
    @Test
    void editMealButtonTest(){
        // Adding items to be deleted
        String itemName = "itemName";
        String itemCalories = "100";
        trackCaloriePage.addItem(itemName, itemCalories);
        trackCaloriePage.clickButtonEditMeal(itemName);
        assertTrue(trackCaloriePage.isButtonUpdateMealVisible(),"Expected for Update Meal button to be visible");
    }

// DeleteMealTest
// BackFromEditButtonTest
// CaloriesUpButtonTest
// CaloriesDownButtonTest

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}