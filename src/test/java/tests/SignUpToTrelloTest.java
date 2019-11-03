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
        assertEquals("E-mail jest już w użyciu przez inne konto. Możesz zalogować się lub odzyskać hasło, by je zresetować.", checkInvalidLoginPrompt);
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
        assertEquals("Hasło musi posiadać co najmniej 8 znaków.", checkInvalidLoginPrompt);
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
}
