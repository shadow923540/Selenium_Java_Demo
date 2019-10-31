package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.TestBase;
import waits.WaitForElement;

import static org.testng.AssertJUnit.assertTrue;

public class AtlassianPage extends TestBase {
    private Logger logger = LogManager.getRootLogger();

    @FindBy(id= "login-submit")
    private WebElement  loginSubmit;

    @FindBy(id="password")
    private WebElement  passwordField;

    @FindBy(xpath = "//div[@id='login-error']/span")
    private WebElement warningMessage;


    public AtlassianPage(){
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public AtlassianPage clickLoginSubmit(){
        WaitForElement.waitUntilElementIsClickable(loginSubmit);
        loginSubmit.click();
        logger.info("Clicked login submit on AtlassianPage");
        return this;
    }

    public TrelloDashBoard clickFinalLoginSubmit(){
        WaitForElement.waitUntilElementIsClickable(loginSubmit);
        loginSubmit.click();
        logger.info("Clicked final login submit on AtlassianPage");
        return new TrelloDashBoard();
    }

    public AtlassianPage typePassword(String passwd){
        WaitForElement.waitUntilElementIsVisible(passwordField);
        passwordField.sendKeys(passwd);
        logger.info("Typed password : "+ passwd);
        return this;
    }

    public AtlassianPage checkIfWarningMessageIsVisible(){
        logger.info("Wait for warning message");
        WaitForElement.waitUntilElementIsVisible(warningMessage);
        assertTrue(warningMessage.isDisplayed());
        logger.info("Warning message is Displayed " + warningMessage);
        return this;
    }

}
