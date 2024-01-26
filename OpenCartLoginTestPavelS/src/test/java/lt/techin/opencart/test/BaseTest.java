package lt.techin.opencart.test;

import lt.techin.opencart.page.BasePage;
import lt.techin.opencart.page.HomePage;
import lt.techin.opencart.page.LoginPage;
import lt.techin.opencart.page.MyAccountPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected HomePage homePage;
    protected BasePage basePage;
    protected LoginPage loginPage;
    protected MyAccountPage myAccountPage;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.get("http://192.168.1.117");
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        basePage = new HomePage(driver);
        myAccountPage = new MyAccountPage(driver);
    }

    @AfterEach
    void driverQuit() {
        driver.quit();
    }

}
