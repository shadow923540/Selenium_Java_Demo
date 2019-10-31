package tests;

import driver.manager.DriverUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.objects.LandingPage;
import page.objects.LoginPage;

import static navigation.ApplicationURLs.APPLICATION_URL;
import static navigation.ApplicationURLs.LOGIN_URL;
import static org.testng.AssertJUnit.assertEquals;

public class LoginToTrelloWithWrongCredentialsTest extends TestBase  {

    @BeforeMethod
    public void beforeTest(){
        super.beforeTest();
        DriverUtils.navigateToPage(LOGIN_URL);
    }

    @Test
    public void loginWithBlankEmailAndPassword(){
        LoginPage loginPage = new LoginPage();
        String WrongCredentialsMessage= loginPage
                .clearUserNameField()
                .clearPasswordField()
                .clickOnLoginButtonWithWrongCredentials()
                .getWarningMessage();
        assertEquals("Missing email" , WrongCredentialsMessage);
    }

    @Test
    public void loginWithCorrectEmailAndPassword(){
        DriverUtils.navigateToPage(APPLICATION_URL);
        LandingPage landingPage = new LandingPage();
        landingPage
                .clickOnLoginButton()
                .typeIntoValidUserNameField("pz65@o2.pl")
                .clickOnLoginButtonWithValidCredentials()
                .clickLoginSubmit()
                .typePassword("netguru123")
                .clickFinalLoginSubmit()
                .checkIfAddDashboardIsVisible();
    }

    @Test
    public void loginWithInValidEmailInvalidPasswd(){
        LoginPage loginPage = new LoginPage();
        String WrongCredentialsMessage= loginPage
                .typeIntoInvalidUserNameField()
                .typeIntoPasswordField("wrong")
                .clickOnLoginButtonWithWrongCredentials()
                .getWarningMessage();
        assertEquals("Invalid password" , WrongCredentialsMessage);
    }

    @Test
    public void loginWithValidEmailAndInvalidPasswd(){
        LoginPage loginPage = new LoginPage();
        loginPage
                .typeIntoValidUserNameField("pz65@o2.pl")
                .clickOnLoginButtonWithValidCredentials()
                .clickLoginSubmit()
                .typePassword("wrongpassword")
                .clickLoginSubmit()
                .checkIfWarningMessageIsVisible();
    }

    @Test
    public void loginWithCorrectUserNameAndPassword(){
        LoginPage loginPage = new LoginPage();
        loginPage
                .typeIntoValidUserNameField("netguru65")
                .clickOnLoginButtonWithValidCredentials()
                .clickLoginSubmit()
                .typePassword("netguru123")
                .clickFinalLoginSubmit()
                .checkIfAddDashboardIsVisible();
    }

    @Test
    public void checkForgotYourPassword(){
        LoginPage loginPage = new LoginPage();
        loginPage
                .typeIntoInvalidUserNameField()
                .clickForgotPassword()
                .checkVisibilityOfForgotPasswdMessage();
    }

    @Test
    public void checkSignInWithGoogle(){
        LoginPage loginPage = new LoginPage();
        loginPage
                .clickSignUpWithGoogle()
                .checkWelcomeMessage();
    }
}
