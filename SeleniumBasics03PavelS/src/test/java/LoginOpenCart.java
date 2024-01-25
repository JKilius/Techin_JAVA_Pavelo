import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.*;

public class LoginOpenCart {
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

    @Test
//    @Disabled
    public void openCartLoginBase() {
        //assert if in right page
        assertEquals("Your Store", driver.getTitle());
        // click on My Account
        driver.findElement(By.xpath("/html//nav[@id='top']/div/div[2]/ul[@class='list-inline']//div/a/span[.='My Account']")).click();
        assertTrue(driver.findElement(By.xpath("/html//nav[@id='top']/div/div[2]/ul[@class='list-inline']//ul[@class='dropdown" +
                "-menu dropdown-menu-right show']//a[@href='http://192.168.1.117/en-gb?route=account/login']")).isDisplayed());
        // click on Login
        driver.findElement(By.xpath("/html//nav[@id='top']/div/div[2]/ul[@class='list-inline']//ul[@class='dropdown" +
                "-menu dropdown-menu-right show']//a[@href='http://192.168.1.117/en-gb?route=account/login']")).click();
        assertEquals("Account Login", driver.getTitle());
    }

    @ParameterizedTest
    @CsvSource({"email1@email.com, testpassword123456789!!!", "notexistingemail@email.com, " +
            "noexistingpassword123456789!!!"})
    public void inputeLoginDetails(String email, String password) {
        openCartLoginBase();
        // input email
        driver.findElement(By.cssSelector("#input-email")).sendKeys(email);
        assertEquals(email, driver.findElement(By.cssSelector("#input-email")).getAttribute("value"));
        // input password
        driver.findElement(By.cssSelector("#input-password")).sendKeys(password);
        assertFalse(driver.findElement(By.cssSelector("#input-password")).getAttribute("value").isEmpty());
        // click on Login button
        driver.findElement(By.xpath("//form[@id='form-login']//button[@type='submit']")).click();
        driver.manage().timeouts().implicitlyWait(ofSeconds(5));
        try {
            assertTrue(driver.findElement(By.xpath("//div[@id='content']/h2[.='My Account']")).isDisplayed());
        } catch (Exception e) {
            System.out.println("Login unsuccessful");
        }
        assertTrue(driver.findElement(By.xpath("//div[@id='content']/h2[.='My Account']")).isDisplayed());
        if (driver.getTitle().equals("My Account")) {
            // click on My Wishlist
            driver.findElement(By.xpath("/html//nav[@id='top']/div/div[2]/ul[@class='list-inline']//div/a/span[.='My Account']")).click();
//        assertTrue(driver.findElement(By.xpath("/html//nav[@id='top']/div/div[2]/ul[@class='list-inline']//ul[@class='dropdown-menu dropdown-menu-right show']//a[@href='http://192.168.1.117/en-gb?route=account/logout']")).isDisplayed());
            // click on Logout
            driver.findElement(By.xpath("/html//nav[@id='top']/div/div[2]/ul[@class='list-inline']//ul[@class='dropdown" +
                    "-menu dropdown-menu-right show']//a[@href='http://192.168.1" +
                    ".117/en-gb?route=account/logout']")).click();
            assertEquals("Account Logout", driver.getTitle());
        }

//                driver.findElement(By.xpath("

    }
}
