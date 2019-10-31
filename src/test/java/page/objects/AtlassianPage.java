package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.TestBase;
import waits.WaitForElement;

public class AtlassianPage extends TestBase {
    private Logger logger = LogManager.getRootLogger();

    @FindBy(id= "login-submit")
    private WebElement  loginSubmit;

    @FindBy(id="password")
    private WebElement  passwordField;

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

    public AtlassianPage typeValidPassword(){
        WaitForElement.waitUntilElementIsVisible(passwordField);
        passwordField.sendKeys("netguru123");
        logger.info("Type valid password");
        return this;
    }


}
