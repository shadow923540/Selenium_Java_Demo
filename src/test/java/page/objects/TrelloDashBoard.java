package page.objects;


import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

import static org.testng.AssertJUnit.assertTrue;

public class TrelloDashBoard extends BasePage {

    @FindBy(xpath = "//span[@name='add']")
    private WebElement addDashBoardIcon;

    @Step("Checking if you are succesfuly log in ")
    public void checkIfAddDashboardIsVisible(){
        WaitForElement.waitUntilElementIsVisible(addDashBoardIcon);
        assertTrue(addDashBoardIcon.isDisplayed());
    }

}
