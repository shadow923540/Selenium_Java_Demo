package page.objects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

public class ForgotPassword extends BasePage {

    @FindBy(css=".section-login-form h1")
    private WebElement resetYourPasswordMessage;

    @Step("Checking if you are navigated to forget password site ")
    public boolean checkVisibilityOfForgotPasswdMessage(){
        WaitForElement.waitUntilElementIsVisible(resetYourPasswordMessage);
        boolean checkIfMessageIsDisplayed = resetYourPasswordMessage.isDisplayed();
        return checkIfMessageIsDisplayed;
    }
}
