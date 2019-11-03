package tests;

import driver.manager.DriverUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.objects.LandingPage;
import page.objects.LoginPage;

import static navigation.ApplicationURLs.APPLICATION_URL;
import static navigation.ApplicationURLs.LOGIN_URL;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class LoginToTrelloTest extends TestBase  {

    @BeforeMethod
    public void beforeTest(){
        super.beforeTest();
        DriverUtils.navigateToPage(LOGIN_URL);
    }

    @Test
    @Description("Test check behavior of application when user left blank fields")
    public void loginWithBlankEmailAndPassword(){
        LoginPage loginPage = new LoginPage();
        String WrongCredentialsMessage= loginPage
                .clearUserNameField()
                .clearPasswordField()
                .clickOnLoginButtonWithWrongCredentials()
                .getWarningMessage();
        assertEquals("Brakujący e-mail" , WrongCredentialsMessage);
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test check behavior of application when user type correct email and correct password")
    public void loginWithCorrectEmailAndPassword(){
        DriverUtils.navigateToPage(APPLICATION_URL);
        LandingPage landingPage = new LandingPage();
        boolean checkIfLogIn = landingPage
                .clickOnLoginButton()
                .typeIntoValidUserNameField("pz65@o2.pl")
                .clickOnLoginButtonWithValidCredentials()
                .clickLoginSubmit()
                .typePassword("netguru123")
                .clickFinalLoginSubmit()
                .checkIfAddDashboardIsVisible();
        assertTrue(checkIfLogIn);
    }

    @Test
    @Description("Test check behavior of application when user type invalid email and invalid password")
    public void loginWithInValidEmailInvalidPasswd(){
        LoginPage loginPage = new LoginPage();
        String WrongCredentialsMessage= loginPage
                .typeIntoInvalidUserNameField()
                .typeIntoPasswordField("wrong")
                .clickOnLoginButtonWithWrongCredentials()
                .getWarningMessage();
        assertEquals("Nieprawidłowe hasło" , WrongCredentialsMessage);
    }

    @Test
    @Description("Test check behavior of application when user type correct email and invalid password")
    public void loginWithValidEmailAndInvalidPasswd(){
        LoginPage loginPage = new LoginPage();
        boolean checkIfLoginFailed = loginPage
                .typeIntoValidUserNameField("pz65@o2.pl")
                .clickOnLoginButtonWithValidCredentials()
                .clickLoginSubmit()
                .typePassword("wrongpassword")
                .clickLoginSubmit()
                .checkIfWarningMessageIsVisible();
        assertTrue(checkIfLoginFailed);
    }

    @Test
    @Description("Test check behavior of application when user type correct USER NAME and correct password")
    public void loginWithCorrectUserNameAndPassword(){
        LoginPage loginPage = new LoginPage();
        boolean checkIfLogIn = loginPage
                .typeIntoValidUserNameField("netguru65")
                .clickOnLoginButtonWithValidCredentials()
                .clickLoginSubmit()
                .typePassword("netguru123")
                .clickFinalLoginSubmit()
                .checkIfAddDashboardIsVisible();
        assertTrue(checkIfLogIn);
    }

    @Test
    @Description("Test check behavior of application when user click forgot password field")
    public void checkForgotYourPassword(){
        LoginPage loginPage = new LoginPage();
        boolean checkVisibilityOfForgotPassword =loginPage
                .typeIntoInvalidUserNameField()
                .clickForgotPassword()
                .checkVisibilityOfForgotPasswdMessage();
        assertTrue(checkVisibilityOfForgotPassword);
    }

    @Test
    @Description("Test check behavior of application when user want to log in with google account")
    public void checkSignInWithGoogle(){
        LoginPage loginPage = new LoginPage();
        String welcomeGoogleMessage = loginPage
                .clickSignInWithGoogle()
                .checkWelcomeMessage();
        assertEquals("Zaloguj się przez Google", welcomeGoogleMessage);
    }
}
