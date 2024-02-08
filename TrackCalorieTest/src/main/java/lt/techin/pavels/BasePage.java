package lt.techin.pavels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BasePage {
   protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
}
