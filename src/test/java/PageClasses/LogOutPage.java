package PageClasses;

import baseClasses.PageBaseClass;
import baseClasses.TopMenuClass;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.sun.deploy.net.proxy.pac.PACFunctionsImpl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOutPage extends PageBaseClass {

    public TopMenuClass topMenu;
  //  ExtentTest logger;

    public LogOutPage(WebDriver driver, ExtentTest logger) {
        super(driver, logger);

        topMenu = new TopMenuClass(driver, logger);
        PageFactory.initElements(driver, topMenu);
    }

    @FindBy(xpath = "//*[@id='wrapper']/div[4]/a")
    public WebElement loginAgain_link;

    public LandingPage clickLoginAgain() {
        logger.log(Status.INFO, "Clicking Login Again Button");
        loginAgain_link.click();
        waitForPageLoad();
        logger.log(Status.PASS, "Clicked the login again Button");
        //return PageFactory.initElements(driver, LandingPage.class);

        LandingPage landingPage = new LandingPage(driver, logger);
        PageFactory.initElements(driver, landingPage);
        return landingPage;
    }


}
