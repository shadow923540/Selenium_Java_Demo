package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class LandingPage {
    private Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//a[@href='/login']")
    private WebElement loginButton;

    public LandingPage(){
        PageFactory.initElements(DriverManager.getWebDriver(),this);
    }

    public LoginPage clickOnLoginButton(){
        WaitForElement.waitUntilElementIsClickable(loginButton);
        loginButton.click();
        logger.info("Clicked on "+ loginButton);
        return new LoginPage();
    }
}
