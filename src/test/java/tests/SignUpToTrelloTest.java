package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import page.objects.LandingPage;
import page.objects.LoginPage;

import static org.testng.AssertJUnit.assertEquals;

public class SignUpToTrelloTest extends TestBase {

    @Test
    @Description("Test check behavior of application when user want to sign up  with google account")
    public void checkSignUpWithGoogle(){
        LandingPage landingPage = new LandingPage();
        String welcomeGoogleMessage = landingPage
                .clickOnSignUp()
                .clickSignUpWithGoogle()
                .checkWelcomeMessage();
        assertEquals("Zaloguj się przez Google", welcomeGoogleMessage);
    }
}
