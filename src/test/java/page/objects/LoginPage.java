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
    private WebElement wrongPasswordMessage;

    public LoginPage(){
        PageFactory.initElements(DriverManager.getWebDriver(),this);
    }

    public LoginPage typeIntoUserNameField(String username){
        WaitForElement.waitUntilElementIsVisible(usernameField);
        usernameField.clear();
        usernameField.sendKeys(username);
        logger.info("Send username" + username);
        return this;
    }

    public LoginPage typeIntoPasswordField(String password){
        passwordField.clear();
        passwordField.sendKeys(password);
        logger.info("Send password" + password);
        return this;
    }

    public LoginPage clickOnLoginButtonWithWrongCredentials(){
        logger.info("Wait for " + loginButton);
        WaitForElement.waitUntilElementIsClickable(loginButton);
        loginButton.click();
        logger.info("Clicked on login button" + loginButton);
        return this;
    }

    public String getWarningMessage(){
        logger.info("Wait for Element" + wrongPasswordMessage);
        WaitForElement.waitUntilElementIsVisible(wrongPasswordMessage);
        logger.info("Element" + wrongPasswordMessage +" is visible");
        String warningText = wrongPasswordMessage.getText();
        return warningText;
    }


}
