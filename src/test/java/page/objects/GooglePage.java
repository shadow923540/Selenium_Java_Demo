package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.TestBase;
import waits.WaitForElement;
import static org.testng.AssertJUnit.assertEquals;

public class GooglePage extends TestBase {

    private Logger logger = LogManager.getRootLogger();

    @FindBy(css = ".Fmgc2c")
    private WebElement googleWelcomeMessage;


    public GooglePage(){
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public GooglePage checkWelcomeMessage(){
        WaitForElement.waitUntilElementIsVisible(googleWelcomeMessage);
        String welcomeMessage = googleWelcomeMessage.getText();
        assertEquals("Zaloguj się przez Google", welcomeMessage);
        return new GooglePage();
    }
}
