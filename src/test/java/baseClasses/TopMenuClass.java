package baseClasses;

import PageClasses.LogOutPage;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopMenuClass extends PageBaseClass {
    //public ExtentTest logger;

    public TopMenuClass(WebDriver driver, ExtentTest logger) {
        super(driver, logger);
    }

    @FindBy(xpath = "//*[@id='wrapper']/div[2]/ul/li[2]/a")
    public WebElement myportfolio_link;

    @FindBy(xpath = "//*[@id='signin_info']/a")
    public WebElement signoutLink;

    public LogOutPage signOutApplication() {
        logger.log(Status.INFO, "Clicking the SignOut Link");
        signoutLink.click();
        logger.log(Status.PASS, "Click SignOut Successfully");
        // return PageFactory.initElements(driver,LogOutPage.class);
        LogOutPage logOutPage = new LogOutPage(driver, logger);
        PageFactory.initElements(driver, logOutPage);
        return logOutPage;

    }
}
