package lt.techin.opencart.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected Wait<WebDriver> wait;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.get("http://192.168.1.117");
        driver.manage().window().maximize();
        wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(3)).pollingEvery(Duration.ofSeconds(1))
                .ignoring(TimeoutException.class);
    }

    @AfterEach
    void driverQuit() {
        driver.quit();
    }

}
