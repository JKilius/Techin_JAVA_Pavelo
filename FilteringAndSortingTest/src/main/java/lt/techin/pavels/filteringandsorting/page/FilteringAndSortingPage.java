package lt.techin.pavels.filteringandsorting.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class FilteringAndSortingPage extends BasePage {
    Select select;
    @FindBy(css = "#page-menu")
    WebElement selectPageSize;
    @FindBy(xpath = "//tbody//td[1]")
    List<WebElement> listElementsColumn1;
    @FindBy(xpath = "//th[@role='columnheader'][1]")
    WebElement sortFirstColumn;
    @FindBy(css = "a[aria-label='Next']")
    WebElement linkNextTablePage;
    @FindBy(css = "a[aria-label='First']")
    WebElement linkFirstTablePage;

    @FindBy (css = "#search-field")
    WebElement inputSearch;

    public FilteringAndSortingPage(WebDriver driver) {
        super(driver);

    }

    public void selectPageSize20() {
        select = new Select(selectPageSize);
        select.selectByIndex(2);
    }

    public void clickSortColumn1() {
        sortFirstColumn.click();
    }

    public List<String> getFirsColumnText() {
        return listElementsColumn1.stream().map(WebElement::getText).toList();
    }

    public void clickLinkNextTablePage() {
        linkNextTablePage.click();
    }

    public boolean isNextButtonDisabled() {
        return linkNextTablePage.getAttribute("aria-disabled").equals("true");
    }

    public void clickLinkFirstTablePage() {
        linkFirstTablePage.click();
    }

    public void enterSearch(String searchText) {
        inputSearch.sendKeys(searchText);
    }
}
