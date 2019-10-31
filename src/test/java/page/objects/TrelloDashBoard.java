package page.objects;

import driver.manager.DriverManager;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.TestBase;
import waits.WaitForElement;

import static org.testng.AssertJUnit.assertTrue;

public class TrelloDashBoard extends TestBase {
    private Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//span[@name='add']")
    private WebElement addDashBoardIcon;

    @Step("Checking if you are succesfuly log in ")
    public void checkIfAddDashboardIsVisible(){
        logger.info("Wait for TrelloDashboard");
        WaitForElement.waitUntilElementIsVisible(addDashBoardIcon);
        assertTrue(addDashBoardIcon.isDisplayed());
        logger.info("Login succesful, find element: " + addDashBoardIcon);
    }

}
