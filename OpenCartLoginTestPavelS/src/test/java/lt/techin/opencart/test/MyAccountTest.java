package lt.techin.opencart.test;

import lt.techin.opencart.page.HomePage;
import lt.techin.opencart.page.LoginPage;
import lt.techin.opencart.page.MyAccountPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class MyAccountTest extends BaseTest {
protected HomePage homePage;
protected LoginPage loginPage;
protected MyAccountPage myAccountPage;
   protected String emailExisting = "email1@email.com";
   protected String passwordExisting = "testpassword123456789!!!";
    protected String emailNotExisting = "notexistingemail@email.com";
   protected String passwordNotExisting = "noexistingpassword123456789!!!";

   @BeforeEach
void setupMyAccountTest(){
    homePage = new HomePage(driver);
    loginPage = new LoginPage(driver);
    myAccountPage= new MyAccountPage(driver);
}
    @Test
    void loginGoodCredentials() {
//        loginPage.login(emailExisting, passwordExisting);
        homePage.clickNavMyAccount();
        homePage.clickLinkDropDownLogin();
        loginPage.enterEmail(emailExisting);
        loginPage.enterPassword(passwordExisting);
        loginPage.clickButtonLogin();
        wait.until(ExpectedConditions.titleIs("My Account"));
        assertEquals("My Account", myAccountPage.getPageTitle());
        myAccountPage.logout();
    }
    @Test
    void logoutSuccessful(){
//        loginPage.login(emailExisting,passwordExisting);
        homePage.clickNavMyAccount();
        homePage.clickLinkDropDownLogin();
        loginPage.enterEmail(emailExisting);
        loginPage.enterPassword(passwordExisting);
        loginPage.clickButtonLogin();

        wait.until(ExpectedConditions.titleIs("My Account"));
        myAccountPage.logout();
        wait.until(ExpectedConditions.titleIs("Account Logout"));
        assertEquals("Account Logout", driver.getTitle());
    }
    @Test
    void loginBadCredentials (){
//        loginPage.login(emailNotExisting,passwordNotExisting);

        homePage.clickNavMyAccount();
        homePage.clickLinkDropDownLogin();
        loginPage.enterEmail(emailNotExisting);
        loginPage.enterPassword(passwordNotExisting);
        loginPage.clickButtonLogin();
        try {
            wait.until(ExpectedConditions.titleIs("My Account"));
        } catch (TimeoutException ignored){}
       assertNotEquals("My Account", myAccountPage.getPageTitle(),"Login Successful");
    }
}
