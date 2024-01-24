import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://techin.lt");
        driver.manage().window().maximize();
        WebElement element = driver.findElement(By.className("search-icon"));
        element.click();
        element = driver.findElement(By.className("header-search"));
        element.click();
        element.sendKeys("java");
        element.sendKeys(Keys.RETURN);
//        driver.quit();
    }

}
