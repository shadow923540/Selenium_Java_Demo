package page.objects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

public class LandingPage extends BasePage {


    @FindBy(xpath = "//a[@href='/login']")
    private WebElement loginButton;

    @FindBy(xpath = "//a[@href='/signup']")
    private WebElement signUpButton;

    @Step("Click Login Button on main page")
    public LoginPage clickOnLoginButton(){
        WaitForElement.waitUntilElementIsClickable(loginButton);
        loginButton.click();
        return new LoginPage();
    }

    @Step("Click Sign up on main page")
    public SignUpPage clickOnSignUp(){
        WaitForElement.waitUntilElementIsClickable(signUpButton);
        signUpButton.click();
        return new SignUpPage();
    }
}
