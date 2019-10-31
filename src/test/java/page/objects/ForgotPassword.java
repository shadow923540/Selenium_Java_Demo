package page.objects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;
import static org.testng.AssertJUnit.assertTrue;

public class ForgotPassword extends BasePage {

    @FindBy(css=".section-login-form h1")
    private WebElement resetYourPasswordMessage;

    @Step("Checking if you are navigated to forget password site ")
    public ForgotPassword checkVisibilityOfForgotPasswdMessage(){
        WaitForElement.waitUntilElementIsVisible(resetYourPasswordMessage);
        assertTrue(resetYourPasswordMessage.isDisplayed());
        return new ForgotPassword();
    }
}
