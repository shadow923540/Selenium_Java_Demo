package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.TestBase;

public class AttlasianPage extends TestBase {
    private Logger logger = LogManager.getRootLogger();

    @FindBy(id= "login-submit")
    private WebElement  loginSubmit;

    @FindBy(id="password")
    private WebElement  passwordField;



    public AttlasianPage(){
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }
}
