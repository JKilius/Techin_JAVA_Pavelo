package lt.techin.opencart.test;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class MyAccountTest extends BaseTest {

   protected String emailExisting = "email1@email.com";
   protected String passwordExisting = "testpassword123456789!!!";
    protected String emailNotExisting = "notexistingemail@email.com";
   protected String passwordNotExisting = "noexistingpassword123456789!!!";


    @Test
    void loginGoodCredentials() {
//        homePage.clickNavMyAccount();
//        homePage.clickLinkDropDownLogin();
//        loginPage.enterEmail(email);
//        loginPage.enterPassword(password);
//        loginPage.clickButtonLogin();
//


        loginPage.login(emailExisting, passwordExisting);
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.titleIs("My Account"));
        assertEquals("My Account", myAccountPage.getPageTitle());
        myAccountPage.logout();
    }
    @Test
    void logoutSuccessful(){
        loginPage.login(emailExisting,passwordExisting);
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.titleIs("My Account"));

        myAccountPage.logout();
        wait.until(ExpectedConditions.titleIs("Account Logout"));
        assertEquals("Account Logout", driver.getTitle());
    }
    @Test
    void loginBadCredentials (){
        loginPage.login(emailNotExisting,passwordNotExisting);
        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            wait.until(ExpectedConditions.titleIs("My Account"));
        } catch (TimeoutException ignored){}
       assertNotEquals("My Account", myAccountPage.getPageTitle(),"Login Successful");
    }
}
