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

    public int getTotalCalories() {
        return Integer.parseInt(totalCalories.getText());
    }

    public void clickButtonAddMeal() {
        buttonAddMeal.click();
    }

    public void enterItemName(String itemName) {
        inputItemName.sendKeys(itemName);
    }

    public void enterItemCalories(int itemCalories){
        inputItemCalories.sendKeys(String.valueOf(itemCalories));
    }

    public void addItem(String itemName, String itemCalories){
        inputItemName.sendKeys(itemName);
        inputItemCalories.sendKeys(itemCalories);
        buttonAddMeal.click();
    }

    public List<String> getCollectionItemsNames() {
        return collectionItems.stream().map(WebElement::getText).map(s -> s.split(" ")[0]).toList();
    }
    public List<String> getCollectionItemsCalories() {
        return collectionItems.stream().map(WebElement::getText).map(s -> s.split(" ")[1]).toList();
//        return collectionItems.stream().map(WebElement::getText).map(s -> s.split(" ")[1]).map(Integer::parseInt).toList();
    }

//    public String getUserName() {
//        String str = locationUserName.getText();
//        String[] parts = str.split(": ");
//        return parts[1];
//    }
}


// Tasks to accomplish in Page:
// Create BasePage
// Create method enterItemName
// Create method enterCalories
// Create method clickAddMeal
// Create method clickClearAll
// Create method clickButtonCalorieUp
// Create method clickButtonCalorieDown
// Create method clickButtonEditMeal
// Create method clickButtonUpdateMeal
// Create method clickButtonDeleteMeal
// Create method clickButtonBackFromEdit
// Create method getTotalCalories