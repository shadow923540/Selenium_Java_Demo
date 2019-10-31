package page.objects;

import driver.manager.DriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.TestBase;
import waits.WaitForElement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginPage extends TestBase {

    private Logger logger = LogManager.getRootLogger();

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
        logger.info("Wait for element: "+ usernameField);
        WaitForElement.waitUntilElementIsVisible(usernameField);
        usernameField.clear();
        usernameField.sendKeys("InvalidUser1");
        logger.info("Send username : InvalidUser1");
        return this;
    }

    @Step("Type into user field valid user name")
    public LoginPage typeIntoValidUserNameField(String user){
        logger.info("Wait for element: "+ usernameField);
        WaitForElement.waitUntilElementIsVisible(usernameField);
        usernameField.clear();
        usernameField.sendKeys(user);
        logger.info("Send username : user");
        WaitForElement.waitUntilElementIsInvisible(forgotPasswordMessage);
        return this;
    }

    @Step("Clear user name field")
    public LoginPage clearUserNameField(){
        WaitForElement.waitUntilElementIsVisible(usernameField);
        usernameField.clear();
        logger.info("Clear username field");
        return this;
    }

    @Step("Type into password field : {password}")
    public LoginPage typeIntoPasswordField(String password){
        passwordField.clear();
        passwordField.sendKeys(password);
        logger.info("Send password" + password);
        return this;
    }

    @Step("Clear password field")
    public LoginPage clearPasswordField(){
        passwordField.clear();
        logger.info("Clear password field");
        return this;
    }

    @Step("Click on login button")
    public LoginPage clickOnLoginButtonWithWrongCredentials(){
        logger.info("Wait for " + loginButton);
        WaitForElement.waitUntilElementIsClickable(loginButton);
        loginButton.click();
        logger.info("Clicked on login button" + loginButton);
        return this;
    }

    @Step("Click on login button")
    public AtlassianPage clickOnLoginButtonWithValidCredentials(){
        loginButton.click();
        logger.info("Clicked on login button with valid credentials");
        return new AtlassianPage();
    }

    @Step("Getting warning message with information about what is wrong")
    public String getWarningMessage(){
        logger.info("Wait for Element" + wrongCredentialsMessange);
        WaitForElement.waitUntilElementIsVisible(wrongCredentialsMessange);
        logger.info("Element" + wrongCredentialsMessange +" is visible");
        String warningText = wrongCredentialsMessange.getText();
        return warningText;
    }

    @Step("Click on forgot password field")
    public ForgotPassword clickForgotPassword(){
        WaitForElement.waitUntilElementIsVisible(forgotPasswordMessage);
        forgotPasswordMessage.click();
        logger.info("Clicked on forgot password field");
        return new ForgotPassword();
    }

    @Step("Click on sign in with google")
    public GooglePage clickSignUpWithGoogle(){
        signInWithGoogle.click();
        logger.info("Clicked on sign with google field");
        return new GooglePage();
    }
}
