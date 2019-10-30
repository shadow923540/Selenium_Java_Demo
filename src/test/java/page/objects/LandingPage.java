package page.objects;

import driver.manager.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class LandingPage {
    @FindBy(xpath = "//a[@href='/login']")
    private WebElement loginButton;

    public LandingPage(){
        PageFactory.initElements(DriverManager.getWebDriver(),this);
    }

    public void clickOnLoginButton(){
        WaitForElement.waitUntilElementIsClickable(loginButton);
        loginButton.click();
    }
}
