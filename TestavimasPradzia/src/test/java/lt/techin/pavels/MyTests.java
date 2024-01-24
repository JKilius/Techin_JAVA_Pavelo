package lt.techin.pavels;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class MyTests {
    private WebDriver driver;

    @BeforeEach
    void driver() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }

    @AfterEach
    void driverQuit() {
        driver.quit();
    }

    @Test
//    @Disabled
    public void test1() {
//        WebElement element = driver.findElement(By.id("user-name"));
//        driver.manage().timeouts().implicitlyWait(ofSeconds(5));
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("password")).sendKeys(Keys.RETURN);
        assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl(), () -> "Url did not " +
                "match");
        assertTrue(driver.findElement(By.className("shopping_cart_link")).isDisplayed(), () -> "Shopping " +
                "cart link not found");
//    https://www.saucedemo.com/
//        driver.manage().timeouts().implicitlyWait(ofSeconds(5));
    }

    @Test
//    @Disabled
    public void test2() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("wrong_password");
        driver.findElement(By.id("password")).sendKeys(Keys.RETURN);
        assertEquals("Epic sadface: Username and password do not match any user in this service",
                driver.findElement(By.cssSelector(".error-message-container.error")).getText());
    }

    @Test
//    @Disabled
    public void test3() {
        driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("password")).sendKeys(Keys.RETURN);
        assertTrue(driver.findElement(By.cssSelector(".error-message-container.error"))
                .getText().contains("this user has been locked out"));
    }

    @ParameterizedTest
//    @Disabled
    @CsvFileSource(files = "src/test/resources/logins.csv", numLinesToSkip = 1)
    public void paraTest(String login, String password) {
        assertNotNull(login);
        assertNotNull(password);
        driver.findElement(By.id("user-name")).sendKeys(login);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("password")).sendKeys(Keys.RETURN);
        assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl(), () -> "Url did not " +
                "match");
        assertTrue(driver.findElement(By.className("shopping_cart_link")).isDisplayed(), () -> "Shopping " +
                "cart link not found");

    }
    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/logins.csv", numLinesToSkip = 1)
    void timeOut (String login, String password){
        assertTimeout(Duration.ofSeconds(2), ()-> {
            paraTest(login,password);
        });
    }

    public static void timeToWait() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }
    }
}
