package page.objects;

import driver.manager.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.TestBase;
import waits.WaitForElement;

public class LoginPage extends TestBase {

    @FindBy(css = ".layout-twothirds-center h1")
    private WebElement loginPageMessage;

    @FindBy(id = "user")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id= "login")
    private WebElement loginButton;

    @FindBy(css = "#error p")
    private WebElement wrongPasswordMessage;

    public LoginPage(){
        PageFactory.initElements(DriverManager.getWebDriver(),this);
    }

    public LoginPage typeIntoUserNameField(String username){
        WaitForElement.waitUntilElementIsVisible(usernameField);
        usernameField.clear();
        usernameField.sendKeys(username);
        return this;
    }

    public LoginPage typeIntoPasswordField(String password){
        passwordField.clear();
        passwordField.sendKeys(password);
        return this;
    }

    public LoginPage clickOnLoginButton(){
        loginButton.click();
        return this;
    }

    public String getWarningMessage(){
        WaitForElement.waitUntilElementIsVisible(wrongPasswordMessage);
        String warningText = wrongPasswordMessage.getText();
        return warningText;
    }

}
