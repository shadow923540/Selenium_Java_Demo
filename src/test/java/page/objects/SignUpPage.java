package page.objects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends BasePage {

    @FindBy(css=".google-button")
    private WebElement signUpWithGoogle;

    @Step("Click on sign up with google")
    public GooglePage clickSignUpWithGoogle(){
        signUpWithGoogle.click();
        return new GooglePage();
    }
}
