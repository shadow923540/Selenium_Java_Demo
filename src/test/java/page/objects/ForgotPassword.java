package page.objects;

import driver.manager.DriverManager;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.TestBase;
import waits.WaitForElement;
import static org.testng.AssertJUnit.assertTrue;

public class ForgotPassword extends TestBase {
    private Logger logger = LogManager.getRootLogger();

    @FindBy(css=".section-login-form h1")
    private WebElement resetYourPasswordMessage;

    @Step("Checking if you are navigated to forget password site ")
    public ForgotPassword checkVisibilityOfForgotPasswdMessage(){
        logger.info("Wait for Info about reset password");
        WaitForElement.waitUntilElementIsVisible(resetYourPasswordMessage);
        logger.info("Info about reset password is visible");
        assertTrue(resetYourPasswordMessage.isDisplayed());
        return new ForgotPassword();
    }
}
