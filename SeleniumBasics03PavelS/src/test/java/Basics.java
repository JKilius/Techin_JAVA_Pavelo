import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class Basics {
    private WebDriver driver;

    @BeforeEach
    void driver() {
        driver = new ChromeDriver();
        driver.get("http://192.168.1.117/");
        driver.manage().window().maximize();
    }

    @AfterEach
    void driverQuit() {
        driver.quit();
    }


    //    EXERCISE 1
//1.Create a new Selenium test under new Java Class
//2.Open https://demo.opencart.com/
//3.Click on a wishlist
    @Test
//    @Disabled
    public void clickOnWishlist() {
        driver.findElement(By.xpath("//a[@id='wishlist-total']/span[.='Wish List (0)']")).click();
        assertEquals("Account Login", driver.getTitle());
    }

    //4.Count and print a number of seach boxes
    @Test
//@Disabled
    public void countNumOfSearchBoxes() {
        clickOnWishlist();
        List<WebElement> inputs = driver.findElements(By.tagName("input"));
        System.out.println(inputs.stream().filter(WebElement::isDisplayed).count());
        assertEquals(3, inputs.stream().filter(WebElement::isDisplayed).count());
    }

    //5.Find element of email input field and enter email “email@email.com”
    @Test
//@Disabled
    public void findInputAndEnterEmail() {
        clickOnWishlist();
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
        clickOnWishlist();
        driver.findElement(By.xpath("//form[@id='form-login']//button[@type='submit']")).click();
        assertTrue(driver.findElement(By.cssSelector("#alert")).isDisplayed());
    }

    //8.Click on register a new customer
    @Test
//@Disabled
    public void clickToRegister() {
        clickOnWishlist();
        driver.findElement(By.xpath("/html//div[@id='content']/div[@class='row']//a[@href='http://192.168.1.117/en-gb?route=account/register']")).click();
        assertEquals("Register Account", driver.getTitle());
    }
//9.Check if the field to input password is enabled and print the result

//10. Check if cart element is displayed and print the result
//11. Check if agree checkbox is selected and print the result
//12. Go to top menu -> Desktops
//13. Select to show 25 items per page
//14. Print selected option from the dropbox
//15. Select 4th option in show items per page dropbox
//16. Print selected option
//17. Close the window


}
