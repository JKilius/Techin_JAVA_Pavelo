package lt.techin.pavels.loginpage.test;

import lt.techin.pavels.loginpage.AccountPage;
import lt.techin.pavels.loginpage.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPageTest {

    protected WebDriver driver;

    protected LoginPage loginPage;
    protected AccountPage accountPage;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage = new LoginPage(driver);
        accountPage = new AccountPage(driver);
        driver.manage().window().maximize();
    }
    @AfterEach
    void tearDown (){
        driver.quit();
    }

    @Test
    void loginSuccessful() {
        String userName = loginPage.getUserName();
        String password = loginPage.getPassword();
        loginPage.enterUserName(userName);
        loginPage.enterPassword(password);
        Assertions.assertTrue(accountPage.isLoginTrue());
        if (accountPage.isLoginTrue()) {
            accountPage.logOut();
        }
    }

    @Test
    void loginUnsuccessful() {
        String userName = "NotAUser";
        String password = "123";
        loginPage.enterUserName(userName);
        loginPage.enterPassword(password);
        Assertions.assertTrue(loginPage.isCredentialAlerTrue());
        Assertions.assertFalse(accountPage.isLoginTrue());
    }

}
