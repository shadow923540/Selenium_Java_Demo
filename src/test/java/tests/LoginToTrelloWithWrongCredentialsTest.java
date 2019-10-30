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
                .clickOnLoginButton()
                .getWarningMessage();

        assertEquals(WrongPasswordMessage,"Invalid password" );
    }



}
