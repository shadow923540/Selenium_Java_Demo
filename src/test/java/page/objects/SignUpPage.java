package page.objects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

public class SignUpPage extends BasePage {

    @FindBy(css=".google-button")
    private WebElement signUpWithGoogle;

    @FindBy(css="#signup")
    private WebElement signUpButton;

    @FindBy(css="#error > p")
    private WebElement invalidLoginPrompt;

    @FindBy(css="#email")
    private WebElement emailField;

    @FindBy(css="#name")
    private WebElement nameField;

    @FindBy(css="#password")
    private WebElement passwordField;

    @FindBy(xpath="//div[@class='board-name']/h2/span")
    private WebElement welcomeMessage;

    @Step("Click on sign up with google")
    public GooglePage clickSignUpWithGoogle(){
        signUpWithGoogle.click();
        return new GooglePage();
    }

    @Step("Check if signUpButton is clickable")
    public boolean signUpIsClickable(){
        WaitForElement.waitUntilElementIsVisible(signUpButton);
        boolean isClickable = signUpButton.isEnabled();
        return isClickable;
    }

    @Step("Type  email into emailField")
    public SignUpPage typeIntoEmailField(String email){
        WaitForElement.waitUntilElementIsVisible(emailField);
        emailField.sendKeys(email);
        return new SignUpPage();
    }

    @Step("Type name into nameField")
    public SignUpPage typeIntoNameField(String name){
        WaitForElement.waitUntilElementIsVisible(nameField);
        nameField.sendKeys(name);
        return new SignUpPage();
    }

    @Step("Type password into passwordField")
    public SignUpPage typeIntoPasswordField(String passwd){
        WaitForElement.waitUntilElementIsVisible(passwordField);
        passwordField.sendKeys(passwd);
        return new SignUpPage();
    }

    @Step("Click signup button")
    public SignUpPage clickSignUpButton(){
        WaitForElement.waitUntilElementIsClickable(signUpButton);
        signUpButton.click();
        return new SignUpPage();
    }

    @Step("Get invalid login prompt after signUp")
    public String getinvalidLoginPrompt(){
        WaitForElement.waitUntilElementIsVisible(invalidLoginPrompt);
        String prompt = invalidLoginPrompt.getText();
        return prompt;
    }

    @Step("Get welcome message after signUp")
    public String getWelcomeMessage(){
        WaitForElement.waitUntilElementIsVisible(welcomeMessage);
        String prompt = welcomeMessage.getText();
        return prompt;
    }





}
