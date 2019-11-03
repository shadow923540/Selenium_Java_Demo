package page.objects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

public class AtlassianPage extends BasePage {

    @FindBy(id= "login-submit")
    private WebElement  loginSubmit;

    @FindBy(id="password")
    private WebElement  passwordField;

    @FindBy(xpath = "//div[@id='login-error']/span")
    private WebElement warningMessage;

    @Step("Click Submin Login on Attlasian Page  ")
    public AtlassianPage clickLoginSubmit(){
        WaitForElement.waitUntilElementIsClickable(loginSubmit);
        loginSubmit.click();
        return this;
    }

    @Step("Click Submin Login with valid email and password on Attlasian login page ")
    public TrelloDashBoard clickFinalLoginSubmit(){
        WaitForElement.waitUntilElementIsClickable(loginSubmit);
        loginSubmit.click();
        return new TrelloDashBoard();
    }

    @Step("Type into password field password : {passwd}")
    public AtlassianPage typePassword(String passwd){
        WaitForElement.waitUntilElementIsVisible(passwordField);
        passwordField.sendKeys(passwd);
        return this;
    }

    @Step("Checking if warning message is visible")
    public boolean checkIfWarningMessageIsVisible(){
        WaitForElement.waitUntilElementIsVisible(warningMessage);
        boolean checkWarningMessage = warningMessage.isDisplayed();
        return checkWarningMessage;
    }
}
