package tests;

import driver.manager.DriverUtils;
import io.qameta.allure.Description;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.objects.LandingPage;
import page.objects.LoginPage;
import page.objects.SignUpPage;

import static navigation.ApplicationURLs.*;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;

public class SignUpToTrelloTest extends TestBase {

    @BeforeMethod
    public void beforeTest(){
        super.beforeTest();
        DriverUtils.navigateToPage(SIGN_UP_URL);
    }

    @Test
    @Description("Test check behavior of application when user want to sign up  with google account")
    public void checkSignUpWithGoogle(){
        DriverUtils.navigateToPage(APPLICATION_URL);
        LandingPage landingPage = new LandingPage();
        String welcomeGoogleMessage = landingPage
                .clickOnSignUp()
                .clickSignUpWithGoogle()
                .checkWelcomeMessage();
        assertEquals("Zaloguj się przez Google", welcomeGoogleMessage);
    }

    @Test
    @Description("Test check behavior of application when user leave email adress field blank and try to sign up")
    public void checkSignUpWithBlankEmail(){
        SignUpPage signUpPage = new SignUpPage();
        boolean isSignUpClickable = signUpPage
                .signUpIsClickable();
        assertFalse(isSignUpClickable);
    }

    @Test
    @Description("Test check behavior of application when user try to use existing email to sign up")
    public void checkSignUpWithExistingEmail(){
        SignUpPage signUpPage = new SignUpPage();
        String checkInvalidLoginPrompt = signUpPage
                .typeIntoEmailField("pz921@wp.pl")
                .clickSignUpButton()
                .typeIntoNameField("Guru")
                .typeIntoPasswordField("hehhehhee")
                .clickSignUpButton()
                .getinvalidLoginPrompt();
        assertEquals("Email already in use by another account. You can use log in or use the forgot password page to reset your password.", checkInvalidLoginPrompt);
    }

    @Test
    @Description("Test check behavior of application when user try  to sign up with short password")
    public void checkSignUpWithShortPassword(){
        SignUpPage signUpPage = new SignUpPage();
        String checkInvalidLoginPrompt = signUpPage
                .typeIntoEmailField("pz921@wp.pl")
                .clickSignUpButton()
                .typeIntoNameField("Guru")
                .typeIntoPasswordField("hehe")
                .clickSignUpButton()
                .getinvalidLoginPrompt();
        assertEquals("Password must be at least 8 characters.", checkInvalidLoginPrompt);
    }

    @Test
    @Description("Test check behavior of application when user try to sign up with empty name")
    public void checkSignUpWithEmptyName(){
        SignUpPage signUpPage = new SignUpPage();
        boolean isSignUpClickable = signUpPage
                .typeIntoEmailField("pz921@wp.pl")
                .clickSignUpButton()
                .typeIntoPasswordField("hehhee")
                .signUpIsClickable();
        assertFalse(isSignUpClickable);
    }

    @Test
    @Description("Test check behavior of application when user try to sign up with empty password")
    public void checkSignUpWithEmptyPassword(){
        SignUpPage signUpPage = new SignUpPage();
        boolean isSignUpClickable = signUpPage
                .typeIntoEmailField("pz921@wp.pl")
                .clickSignUpButton()
                .typeIntoNameField("Pawel")
                .signUpIsClickable();
        assertFalse(isSignUpClickable);
    }

    @Test
    @Description("Test check behavior of application when user try signUp with correct data")
    public void checkSignUpWithCorrectData(){
        SignUpPage signUpPage = new SignUpPage();
        String ifUserSignUp = signUpPage
                .typeIntoEmailField("pz65@o2.pl")
                .clickSignUpButton()
                .typeIntoNameField("Guru")
                .typeIntoEmailField("pz543808732@wp.pl")
                .typeIntoPasswordField("qwertyqwert")
                .clickSignUpButton()
                .getWelcomeMessage();
        assertEquals("Welcome to Trello!", ifUserSignUp);
    }
}
