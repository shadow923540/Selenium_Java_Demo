package tests;

import org.testng.annotations.Test;
import page.objects.LandingPage;
import static org.testng.AssertJUnit.assertEquals;

public class LoginToTrelloWithWrongCredentialsTest extends TestBase  {

    @Test
    public void LoginWithWrongPassword(){
        LandingPage landingPage = new LandingPage();
        String WrongPasswordMessage = landingPage
                .clickOnLoginButton()
                .typeIntoUserNameField("pz921@wp.pl")
                .typeIntoPasswordField("wrongpassword")
                .clickOnLoginButtonWithWrongCredentials()
                .getWarningMessage();

        assertEquals("Invalid password", WrongPasswordMessage );
    }

    @Test
    public void LoginWithWrongEmail(){
        LandingPage landingPage = new LandingPage();
        String WrongPasswordMessage = landingPage
                .clickOnLoginButton()
                .typeIntoUserNameField("pz926456456451@wp.pl")
                .typeIntoPasswordField("wrongpassword")
                .clickOnLoginButtonWithWrongCredentials()
                .getWarningMessage();

        assertEquals("There isn't an account for this email" , WrongPasswordMessage);
    }

}
