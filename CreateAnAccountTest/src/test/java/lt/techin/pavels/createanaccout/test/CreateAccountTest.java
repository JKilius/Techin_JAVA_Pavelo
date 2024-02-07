package lt.techin.pavels.createanaccout.test;

import lt.techin.pavels.createanaccout.page.LandingPage;
import lt.techin.pavels.createanaccout.page.RegisterPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import utils.TestUtils;

import java.util.Objects;

import static java.lang.invoke.MethodHandles.lookup;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

public class CreateAccountTest {
    protected WebDriver driver;
    protected LandingPage landingPage;
    protected RegisterPage registerPage;

    private static final Logger log = getLogger(lookup().lookupClass());

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        landingPage = new LandingPage(driver);
        registerPage = new RegisterPage(driver);
        log.info("Test environment initialized");
        String URL = "https://practice.expandtesting.com/notes/app";
        driver.get(URL);
        log.info("Navigated to {}", URL);
        driver.manage().window().maximize();
    }

    @Test
    void registerPageLoadedTest() {
        log.info("registerPageLoadedTest started");
        landingPage.linkCreateAnAccountClick();
        String currentURL = driver.getCurrentUrl();
        assertThat(currentURL).as("Expected URL to contain '/register").contains("/register");
        log.info(("registerPageLoadedTest completed"));
    }

    @Test
    void registerTest() {
        log.info("registerTest started");
        landingPage.linkCreateAnAccountClick();
        String emailUnique = TestUtils.emailGenerateByTime();
        String name = "John";
        String password = "password123";
        registerPage.enterEmailAddress(emailUnique);
        registerPage.enterName(name);
        registerPage.enterPassword(password);
        registerPage.enterConfirmPassword(password);
        registerPage.submitRegisterClick();
        assertThat(registerPage.isAlertRegisterSuccessVisible()).as("Expected successful registration alert to be " +
                "visible").isTrue();
        log.info(("registerTest completed"));
    }

    @ParameterizedTest
//    @CsvSource({
//            "           '', 'testName', 'password123', 'password123', 'Email address is required'",
//            "' notAnEmail', 'testName', 'password123', 'password123', 'Email address is invalid'",
//            "'uniqueEmail',         '', 'password123', 'password123', 'User name is required'",
//            "'uniqueEmail',      'nam', 'password123', 'password123', 'User name should be between 4 and 30 characters'",
//            "'uniqueEmail', 'veryLongNamePast30Characterslia', 'password123', 'password123', 'User name should be " +
//                                                                                                "between 4 and 30 characters'",
//            "'uniqueEmail', 'testName',            '', 'password123', 'Password is required'",
//            "'uniqueEmail', 'testName', 'short',       'password123', 'Password should be between 6 and 30 characters'",
//            "'uniqueEmail', 'testName', 'veryLongPassPast30Characterslia','veryLongPassPast30Characterslia', 'Password should be " +
//                                                                                                "between 6 and 30 characters'",
//            "'uniqueEmail', 'testName', 'password123',            '', 'Confirm Password is required'",
//            "'uniqueEmail', 'testName', 'password123', 'notMatchingPass321', 'Passwords don''t match!'",
//    })
    @CsvFileSource (resources = "/testData.csv", numLinesToSkip = 1)
    void registerFailParameterizedTest(String email, String name, String password, String confirmPassword,
                                       String expectedAlertMessage) {
        log.info("registerFailTest started");
        landingPage.linkCreateAnAccountClick();
        if (Objects.equals(email, "uniqueEmail")) {
            email = TestUtils.emailGenerateByTime();
        }
        registerPage.enterEmailAddress(email);
        registerPage.enterName(name);
        registerPage.enterPassword(password);
        registerPage.enterConfirmPassword(confirmPassword);
        registerPage.submitRegisterClick();
        assertThat(registerPage.isAlertWithTextVisible(expectedAlertMessage)).as("Expected alert message to be visible: " + expectedAlertMessage).isTrue();
        log.info(("registerTest completed"));
//        Assertions.assertTrue(registerPage.isAlertWithTextVisible(expectedAlertMessage),"Expected alert message to be visible: " + expectedAlertMessage);
    }



    
    @AfterEach
    void tearDown() {
        driver.quit();
        log.info("WebDriver closed");
    }
}
