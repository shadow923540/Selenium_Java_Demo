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

/*    @Test
    public void LoginWithCorrectLoginAndPassword(){
        LoginPage loginPage = new LoginPage();
        String WrongCredentialsMessage= loginPage
                .typeIntoUserNameField("pz65@o2.pl")
                .typeIntoPasswordField("netguru123")
                .clickOnLoginButtonWithWrongCredentials()
                .getWarningMessage();
        assertEquals("To nie jest konto dla tego e-maila" , WrongCredentialsMessage);
    }*/

    @Test
    public void LoginWithWrongPassword(){
        DriverUtils.navigateToPage(APPLICATION_URL);
        LandingPage landingPage = new LandingPage();
        String WrongPasswordMessage = landingPage
                .clickOnLoginButton()
                .typeIntoUserNameField("pz921@wp.pl")
                .typeIntoPasswordField("wrongpassword")
                .clickOnLoginButtonWithWrongCredentials()
                .getWarningMessage();
        assertEquals("This account doesn't have a password set - perhaps you normally log in with Google or SSO? If you're stuck, choose 'Forgot your password?'", WrongPasswordMessage );
    }

    @Test
    public void LoginWithWrongEmail(){
        LoginPage loginPage = new LoginPage();
        String WrongCredentialsMessage= loginPage
                .typeIntoUserNameField("pz926456456451@wp.pl")
                .typeIntoPasswordField("wrong")
                .clickOnLoginButtonWithWrongCredentials()
                .getWarningMessage();
//        assertEquals("To nie jest konto dla tego e-maila" , WrongCredentialsMessage);
    }

    @Test
    public void LoginWithBlankEmailAndPassword(){
        LoginPage loginPage = new LoginPage();
        String WrongCredentialsMessage= loginPage
                .clearUserNameField()
                .clearPasswordField()
                .clickOnLoginButtonWithWrongCredentials()
                .getWarningMessage();
//        assertEquals("Brakujący e-mail" , WrongCredentialsMessage);
    }

}
