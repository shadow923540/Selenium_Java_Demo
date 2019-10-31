package page.objects;

import driver.manager.DriverManager;
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

    public LoginPage(){
        PageFactory.initElements(DriverManager.getWebDriver(),this);
    }

    public LoginPage typeIntoInvalidUserNameField(){
        WaitForElement.waitUntilElementIsVisible(usernameField);
        usernameField.clear();
        usernameField.sendKeys("InvalidUser1");
        logger.info("Send username : InvalidUser1");
        return this;
    }

    public LoginPage typeIntoValidUserNameField(String user){
        WaitForElement.waitUntilElementIsVisible(usernameField);
        usernameField.clear();
        usernameField.sendKeys(user);
        logger.info("Send username : user");
        WaitForElement.waitUntilElementIsInvisible(forgotPasswordMessage);
        return this;
    }

    public LoginPage clearUserNameField(){
        WaitForElement.waitUntilElementIsVisible(usernameField);
        usernameField.clear();
        return this;
    }

    public LoginPage typeIntoPasswordField(String password){
        passwordField.clear();
        passwordField.sendKeys(password);
        logger.info("Send password" + password);
        return this;
    }

    public LoginPage clearPasswordField(){
        passwordField.clear();
        return this;
    }

    public LoginPage clickOnLoginButtonWithWrongCredentials(){
        logger.info("Wait for " + loginButton);
        WaitForElement.waitUntilElementIsClickable(loginButton);
        loginButton.click();
        logger.info("Clicked on login button" + loginButton);
        return this;
    }

    public AtlassianPage clickOnLoginButtonWithValidCredentials(){
        loginButton.click();
        return new AtlassianPage();
    }

    public String getWarningMessage(){
        logger.info("Wait for Element" + wrongCredentialsMessange);
        WaitForElement.waitUntilElementIsVisible(wrongCredentialsMessange);
        logger.info("Element" + wrongCredentialsMessange +" is visible");
        String warningText = wrongCredentialsMessange.getText();
        return warningText;
    }

    public ForgotPassword clickForgotPassword(){
        WaitForElement.waitUntilElementIsVisible(forgotPasswordMessage);
        forgotPasswordMessage.click();
        return new ForgotPassword();
    }

}
