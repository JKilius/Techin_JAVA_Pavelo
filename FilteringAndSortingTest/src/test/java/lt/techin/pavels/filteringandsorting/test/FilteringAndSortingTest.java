package lt.techin.pavels.filteringandsorting.test;

import lt.techin.pavels.filteringandsorting.page.FilteringAndSortingPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilteringAndSortingTest {
    protected WebDriver driver;
    protected FilteringAndSortingPage filteringAndSortingPage;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        filteringAndSortingPage = new FilteringAndSortingPage(driver);
        driver.manage().window().maximize();
    }
    @AfterEach
    void tearDown (){
        driver.quit();
    }

    @Test
    void verifySortingByAlphabetPageSize20() {
        filteringAndSortingPage.selectPageSize20();

        List<String> javaSortedList =
                filteringAndSortingPage.getFirsColumnText().stream().sorted(String::compareTo).toList();
        filteringAndSortingPage.clickSortColumn1();
        List<String> pageSortedList = filteringAndSortingPage.getFirsColumnText();
        assertEquals(javaSortedList, pageSortedList);
    }

    @Test
    void verifySortingByAlphabetPageSize5() {
        List<String> listUnsortedColumns = new ArrayList<>();
        while (true) {
            List<String> unsortedColumn = filteringAndSortingPage.getFirsColumnText();
            listUnsortedColumns.addAll(unsortedColumn);
            if (filteringAndSortingPage.isNextButtonDisabled()) break;
            filteringAndSortingPage.clickLinkNextTablePage();
        }

        filteringAndSortingPage.clickLinkFirstTablePage();
        filteringAndSortingPage.clickSortColumn1();
        List<String> listPageSortedColumns = new ArrayList<>();

        while (true) {
            List<String> pageSortedColumn = filteringAndSortingPage.getFirsColumnText();
            listPageSortedColumns.addAll(pageSortedColumn);
            if (filteringAndSortingPage.isNextButtonDisabled()) break;
            filteringAndSortingPage.clickLinkNextTablePage();
        }
        List<String> listJavaSortedColumns =
                new ArrayList<>(listUnsortedColumns.stream().sorted(String::compareTo).toList());
        assertEquals(listJavaSortedColumns, listPageSortedColumns);
    }

    @Test
    void verifySearchFunctionality() {
        String searchText = "an";
        List<String> listUnsortedColumns = new ArrayList<>();
        while (true) {
            List<String> unsortedColumn = filteringAndSortingPage.getFirsColumnText();
            listUnsortedColumns.addAll(unsortedColumn);
            if (filteringAndSortingPage.isNextButtonDisabled()) break;
            filteringAndSortingPage.clickLinkNextTablePage();
        }
        filteringAndSortingPage.enterSearch(searchText);
        List<String> javaSearchResultList = listUnsortedColumns.stream().filter(st -> st.contains(searchText)).toList();
        List<String> pageSearchResultList = filteringAndSortingPage.getFirsColumnText();
        assertEquals(javaSearchResultList, pageSearchResultList);

    }
}
