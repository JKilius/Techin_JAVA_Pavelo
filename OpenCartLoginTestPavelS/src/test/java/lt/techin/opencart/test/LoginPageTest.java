package lt.techin.opencart.test;

import lt.techin.opencart.page.HomePage;
import lt.techin.opencart.page.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoginPageTest extends BaseTest{
    protected HomePage homePage;
    protected LoginPage loginPage;

    @BeforeEach
    void setupHomepage() {
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    @Test
    void inputEmailSuccessful() {
        homePage.clickNavMyAccount();
        homePage.clickLinkDropDownLogin();

        String email = "email1@email.com";
        loginPage.enterEmail(email);
        assertEquals(email, loginPage.getInputEmailValue());
    }
    @Test
    void inputPasswordSuccessful(){
        homePage.clickNavMyAccount();
        homePage.clickLinkDropDownLogin();

        String password = "testpassword123456789!!!";
        loginPage.enterPassword(password);
        assertFalse(loginPage.getInputPasswordValue().isEmpty());
    }
}
