package page.objects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;
import static org.testng.AssertJUnit.assertEquals;

public class GooglePage extends BasePage {

    @FindBy(css = ".Fmgc2c")
    private WebElement googleWelcomeMessage;

    @Step("Checking if you are navigated to google login page ")
    public String checkWelcomeMessage(){
        WaitForElement.waitUntilElementIsVisible(googleWelcomeMessage);
        String welcomeMessage = googleWelcomeMessage.getText();
        return welcomeMessage;
    }
}
