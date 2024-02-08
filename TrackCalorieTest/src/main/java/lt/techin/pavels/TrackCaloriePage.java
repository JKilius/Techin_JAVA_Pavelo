package lt.techin.pavels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TrackCaloriePage extends BasePage {
    public TrackCaloriePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input#item-name")
    private WebElement inputItemName;
    @FindBy(css = "input#item-calories")
    private WebElement inputItemCalories;
    @FindBy(css = ".add-btn.blue.btn.darken-3")
    private WebElement buttonAddMeal;
    @FindBy(css = ".total-calories")
    private WebElement totalCalories;
    @FindBy(css = ".collection-item")
    private List<WebElement> collectionItems;
    @FindBy(css = ".clear-btn.btn.blue.lighten-3")
    private WebElement buttonClearAll;

    // Create method getTotalCalories
    public int getTotalCalories() {
        return Integer.parseInt(totalCalories.getText());
    }

    // Create method clickAddMeal
    public void clickButtonAddMeal() {
        buttonAddMeal.click();
    }

    // Create method enterItemName
    public void enterItemName(String itemName) {
        inputItemName.sendKeys(itemName);
    }

    // Create method enterCalories
    public void enterItemCalories(int itemCalories) {
        inputItemCalories.sendKeys(String.valueOf(itemCalories));
    }

    public void addItem(String itemName, String itemCalories) {
        inputItemName.sendKeys(itemName);
        inputItemCalories.sendKeys(itemCalories);
        buttonAddMeal.click();
    }

    public List<String> getCollectionItemsNames() {
        return collectionItems.stream().map(WebElement::getText).map(s -> s.split(" ")[0]).toList();
    }

    public List<String> getCollectionItemsCalories() {
        return collectionItems.stream().map(WebElement::getText).map(s -> s.split(" ")[1]).toList();
    }

    // Create method clickClearAll
    public void clickButtonClearAll(){
        buttonClearAll.click();
    }
}


// Tasks to accomplish in Page:
// Create BasePage

// Create method clickButtonCalorieUp
// Create method clickButtonCalorieDown
// Create method clickButtonEditMeal
// Create method clickButtonUpdateMeal
// Create method clickButtonDeleteMeal
// Create method clickButtonBackFromEdit
