import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Basics {
    private WebDriver driver;
    private WebDriverWait wait;
    private Select select;

    @FindBy(xpath = "//a[@class=\"dropdown-item\"][.=\"Login\"]")
    WebElement linkLogin;
    @FindBy(xpath = "//button[.=\"Login\"]")
    WebElement buttonLogin;
    //    @FindBy (xpath ="//input[@type='password']")
    @FindBy(css = "input[type='password']")
    WebElement inputPassword;
    @FindBy(css = "button i[class=\"fa-solid fa-cart-shopping\"]")
    WebElement buttonShopingCart;
    @FindBy(xpath = "//a[.=\"Continue\"]")
    WebElement linkRegister;
    @FindBy(css = "input[name='agree']")
    WebElement inputCheckboxAgree;
    @FindBy(xpath = "//a[@data-bs-toggle='dropdown'][.='Desktops']")
    WebElement linkDesktops;
    @FindBy(xpath = "//a[.='Show All Desktops']")
    WebElement linkShowAllDesktops;
    @FindBy(css = "select#input-limit")
    WebElement selectShowNumberOfItems;

    @BeforeEach
    void driver() {
        driver = new ChromeDriver();
        driver.get("http://192.168.1.117/");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[alt='Your Store']")));
        PageFactory.initElements(driver, this);
    }


    //    EXERCISE 1
//1.Create a new Selenium test under new Java Class
//2.Open https://demo.opencart.com/

    //3.Click on a wishlist
    @Test
//    @Disabled
    public void clickOnWishlist() {
        driver.findElement(By.xpath("//span[.=\"My Account\"]")).click();
        assertTrue(linkLogin.isDisplayed());
    }

    //4.Count and print a number of seach boxes
    @Test
//@Disabled
    public void countNumOfSearchBoxes() {
        driver.findElement(By.xpath("//span[.=\"My Account\"]")).click();
        linkLogin.click();
        List<WebElement> inputs = driver.findElements(By.tagName("input"));
        System.out.println(inputs.stream().filter(WebElement::isDisplayed).count());
        assertEquals(3, inputs.stream().filter(WebElement::isDisplayed).count());
    }

    //5.Find element of email input field and enter email “email@email.com”
    @Test
//@Disabled
    public void findInputAndEnterEmail() {
        driver.findElement(By.xpath("//span[.=\"My Account\"]")).click();
        linkLogin.click();
        driver.findElement(By.id("input-email")).sendKeys("email@email.com");
//        System.out.println(driver.findElement(By.id("input-email")).getAttribute("value"));
        assertEquals("email@email.com", driver.findElement(By.id("input-email")).getAttribute("value"));


    }

    //6.Clear previous field
    @Test
//@Disabled
    public void clearPreviousField() {
        findInputAndEnterEmail();
        driver.findElement(By.id("input-email")).clear();
//        System.out.println(driver.findElement(By.id("input-email")).getAttribute("value"));
        assertEquals("", driver.findElement(By.id("input-email")).getAttribute("value"));
    }

    //7.Submit form
    @Test
//@Disabled
    public void submitForm() {
        driver.findElement(By.xpath("//span[.=\"My Account\"]")).click();
        linkLogin.click();
        buttonLogin.click();
        assertTrue(driver.findElement(By.cssSelector("#alert")).isDisplayed());
    }

    //8.Click on register a new customer
    @Test
//@Disabled
    public void clickToRegister() {
        driver.findElement(By.xpath("//span[.=\"My Account\"]")).click();
        linkLogin.click();
        linkRegister.click();
        assertEquals("Register Account", driver.getTitle());
    }

    //9.Check if the field to input password is enabled and print the result
    @Test
    void isFieldPasswordEnabled() {
        driver.findElement(By.xpath("//span[.=\"My Account\"]")).click();
        linkLogin.click();
        linkRegister.click();
        System.out.println(inputPassword.isEnabled());
    }

    //10. Check if cart element is displayed and print the result
    @Test
    void isShopingCartDisplayed() {
        assertTrue(buttonShopingCart.isDisplayed());
    }

    //11. Check if agree checkbox is selected and print the result
    @Test
    void isChecboxAgreeSelected() {
        driver.findElement(By.xpath("//span[.=\"My Account\"]")).click();
        linkLogin.click();
        linkRegister.click();
        System.out.println(inputCheckboxAgree.isSelected());
    }

    //12. Go to top menu -> Desktops
    @Test
    void goToDesktops() {
        linkDesktops.click();
        linkShowAllDesktops.click();
        assertTrue(driver.getCurrentUrl().contains("/catalog/desktops"));
    }

    //13. Select to show 25 items per page
    @Test
    void selectToShow25() {
        linkDesktops.click();
        linkShowAllDesktops.click();
        Select select = new Select(selectShowNumberOfItems);
        select.selectByVisibleText("25");
        assertTrue(select.getFirstSelectedOption().getText().contains("25"));
    }
//14. Print selected option from the dropbox

    @Test
    void selectPrintSelectedOption() {
        linkDesktops.click();
        linkShowAllDesktops.click();
        select = new Select(selectShowNumberOfItems);
        select.selectByVisibleText("25");
        System.out.println(select.getFirstSelectedOption().getText());
    }

    //15. Select 4th option in show items per page dropbox
//16. Print selected option
    @Test
    void select4thItem() {
        linkDesktops.click();
        linkShowAllDesktops.click();
        select = new Select(selectShowNumberOfItems);
        select.selectByIndex(3);
        System.out.println(select.getFirstSelectedOption().getText());
    }

    //17. Close the window
    @AfterEach
    void driverQuit() {
        driver.quit();
    }

}
