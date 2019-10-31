package page.objects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;


public class LoginPage extends BasePage {

    @FindBy(css = ".layout-twothirds-center h1")
    private WebElement loginPageMessage;

    @FindBy(id = "user")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@id='login']")
    private WebElement loginButton;

    @FindBy(xpath = "//div[contains(@id,'error') and contains(@class,'quick-switch')]/p")
    private WebElement wrongCredentialsMessange;

    @FindBy(xpath = "//a[@href = '/forgot']")
    private WebElement forgotPasswordMessage;

    @FindBy(css=".google-button")
    private WebElement signInWithGoogle;

    @Step("Type into user field invalid user name")
    public LoginPage typeIntoInvalidUserNameField(){
        WaitForElement.waitUntilElementIsVisible(usernameField);
        usernameField.clear();
        usernameField.sendKeys("InvalidUser1");
        return this;
    }

    @Step("Type into user field valid user name")
    public LoginPage typeIntoValidUserNameField(String user){
        WaitForElement.waitUntilElementIsVisible(usernameField);
        usernameField.clear();
        usernameField.sendKeys(user);
        WaitForElement.waitUntilElementIsInvisible(forgotPasswordMessage);
        return this;
    }

    @Step("Clear user name field")
    public LoginPage clearUserNameField(){
        WaitForElement.waitUntilElementIsVisible(usernameField);
        usernameField.clear();
        return this;
    }

    @Step("Type into password field : {password}")
    public LoginPage typeIntoPasswordField(String password){
        passwordField.clear();
        passwordField.sendKeys(password);
        return this;
    }

    @Step("Clear password field")
    public LoginPage clearPasswordField(){
        passwordField.clear();
        return this;
    }

    @Step("Click on login button")
    public LoginPage clickOnLoginButtonWithWrongCredentials(){
        WaitForElement.waitUntilElementIsClickable(loginButton);
        loginButton.click();
        return this;
    }

    @Step("Click on login button")
    public AtlassianPage clickOnLoginButtonWithValidCredentials(){
        loginButton.click();
        return new AtlassianPage();
    }

    @Step("Getting warning message with information about what is wrong")
    public String getWarningMessage(){
        WaitForElement.waitUntilElementIsVisible(wrongCredentialsMessange);
        String warningText = wrongCredentialsMessange.getText();
        return warningText;
    }

    @Step("Click on forgot password field")
    public ForgotPassword clickForgotPassword(){
        WaitForElement.waitUntilElementIsVisible(forgotPasswordMessage);
        forgotPasswordMessage.click();
        return new ForgotPassword();
    }

    @Step("Click on sign in with google")
    public GooglePage clickSignUpWithGoogle(){
        signInWithGoogle.click();
        return new GooglePage();
    }
}
