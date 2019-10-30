package tests;

import driver.manager.DriverUtils;
import org.testng.annotations.Test;
import page.objects.LoginPage;

import static navigation.ApplicationURLs.LOGIN_URL;
import static org.testng.AssertJUnit.assertEquals;

public class LoginToTrelloWithWrongCredentialsTest extends TestBase  {

    @Test
    public void LoginWithWrongPassword(){
        DriverUtils.navigateToPage(LOGIN_URL);
        LoginPage loginPage = new LoginPage();
        String WrongPasswordMessage = loginPage
                .typeIntoUserNameField("pz921@wp.pl")
                .typeIntoPasswordField("wrongpassword")
                .clickOnLoginButtonWithWrongCredentials()
                .getWarningMessage();

        assertEquals("Invalid password", WrongPasswordMessage );
    }

    @Test
    public void LoginWithWrongEmail(){
        DriverUtils.navigateToPage(LOGIN_URL);
        LoginPage loginPage = new LoginPage();
        String WrongPasswordMessage = loginPage
                .typeIntoUserNameField("pz926456456451@wp.pl")
                .typeIntoPasswordField("wrongpassword")
                .clickOnLoginButtonWithWrongCredentials()
                .getWarningMessage();

        assertEquals("There isn't an account for this email" , WrongPasswordMessage);
    }

}
