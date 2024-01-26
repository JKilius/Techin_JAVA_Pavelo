package lt.techin.opencart.test;

import lt.techin.opencart.page.BasePage;
import lt.techin.opencart.page.HomePage;
import lt.techin.opencart.page.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePageTest extends BaseTest {
//    protected HomePage homePage;
//    protected BasePage basePage;
//    protected LoginPage loginPage;

//    @BeforeEach
//    void setupHomepage() {
//        loginPage = new LoginPage(driver);
//        homePage = new HomePage(driver);
//        basePage = new HomePage(driver);
//    }

    @Test
    void isNavMyAccountClickSuccessful() {
        homePage.clickNavMyAccount();
        assertTrue(homePage.isLinkDropDownLoginDisplayed());
    }

    @Test
    void isLinkDropDownLoginClickSuccessful() {
        homePage.clickNavMyAccount();
        homePage.clickLinkDropDownLogin();
        assertEquals("Account Login", basePage.getPageTitle(),"link drop down login click failed");
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

    }

}
