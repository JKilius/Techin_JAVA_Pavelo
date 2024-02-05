package lt.techin.pavels.createanaccout.test;

import lt.techin.pavels.createanaccout.page.LandingPage;
import lt.techin.pavels.createanaccout.page.RegisterPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.TestUtils;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CreateAccountTest {
    protected WebDriver driver;
    protected LandingPage landingPage;
    protected RegisterPage registerPage;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.get("https://practice.expandtesting.com/notes/app");
        driver.manage().window().maximize();
        landingPage = new LandingPage(driver);
        registerPage = new RegisterPage(driver);
    }

    @Test
    void registerPageLoadedTest() {
        landingPage.linkCreateAnAccountClick();
        String currentURL = driver.getCurrentUrl();
        assertThat(currentURL).contains("/register");
    }

    @Test
    void registerTest() {
        landingPage.linkCreateAnAccountClick();
        String emailUnique = TestUtils.emailGenerateByTime();
        String name = "John";
        String password = "password123";
        registerPage.enterEmailAddress(emailUnique);
        registerPage.enterName(name);
        registerPage.enterPassword(password);
        registerPage.enterConfirmPassword(password);
        registerPage.submitRegisterClick();
        assertThat(registerPage.isAlertRegisterSuccessVisible()).isTrue();
    }

    @Test
    void registerFailNoEmailAlertTest(){
        landingPage.linkCreateAnAccountClick();
        String name = "John";
        String password = "password123";
        registerPage.enterName(name);
        registerPage.enterPassword(password);
        registerPage.enterConfirmPassword(password);
        registerPage.submitRegisterClick();
        assertThat(registerPage.isAlertEmailRequiredVisible()).isTrue();
    }
    @Test
    void registerFailNoUserNameAlertTest(){
        landingPage.linkCreateAnAccountClick();
        String emailUnique = TestUtils.emailGenerateByTime();
        String password = "password123";
        registerPage.enterEmailAddress(emailUnique);
        registerPage.enterPassword(password);
        registerPage.enterConfirmPassword(password);
        registerPage.submitRegisterClick();
        assertThat(registerPage.isAlertUserNameRequiredVisible()).isTrue();
    }
    @Test
    void registerFailNoPasswordAlertTest(){
        landingPage.linkCreateAnAccountClick();
        String emailUnique = TestUtils.emailGenerateByTime();
        String name = "John";
        String password = "password123";
        registerPage.enterEmailAddress(emailUnique);
        registerPage.enterName(name);
        registerPage.enterConfirmPassword(password);
        registerPage.submitRegisterClick();
        assertThat(registerPage.isAlertPasswordRequiredVisible()).isTrue();
    }
    @Test
    void registerFailNoConfirmPasswordAlertTest(){
        landingPage.linkCreateAnAccountClick();
        String emailUnique = TestUtils.emailGenerateByTime();
        String name = "John";
        String password = "password123";
        registerPage.enterEmailAddress(emailUnique);
        registerPage.enterName(name);
        registerPage.enterPassword(password);
        registerPage.submitRegisterClick();
        assertThat(registerPage.isAlertConfirmPasswordRequiredVisible()).isTrue();
    }
    @Test
    void registerFailPasswordDontMatchAlertTest() {
        landingPage.linkCreateAnAccountClick();
        String emailUnique = TestUtils.emailGenerateByTime();
        String name = "John";
        String password = "password123";
        String unmachingPassword = "unmatchingpass321";
        registerPage.enterEmailAddress(emailUnique);
        registerPage.enterName(name);
        registerPage.enterPassword(password);
        registerPage.enterConfirmPassword(unmachingPassword);
        registerPage.submitRegisterClick();
        assertThat(registerPage.isAlertPasswordsDoNotMatchVisible()).isTrue();
    }

}
