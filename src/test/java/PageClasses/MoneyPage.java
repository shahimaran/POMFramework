package PageClasses;

import baseClasses.PageBaseClass;
import baseClasses.TopMenuClass;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MoneyPage extends PageBaseClass {
    public TopMenuClass topMenu;
    public MoneyPage(WebDriver driver, ExtentTest logger) {
        super(driver, logger);
        topMenu = new TopMenuClass(driver, logger);
        PageFactory.initElements(driver, topMenu);
    }

    @FindBy(xpath = "//*[@id='signin_info']/a[1]")
    public WebElement signinLink;

    public PortfolioLoginPAge clickSigninLink() {
        logger.log(Status.INFO, "Clicking the Sign-In Link");
        signinLink.click();
        waitForPageLoad();
        logger.log(Status.PASS, "Clicked the Sign-In Lin Successfully");

        PortfolioLoginPAge portfolioLogin = new PortfolioLoginPAge(driver, logger);
        PageFactory.initElements(driver, portfolioLogin);
        return portfolioLogin;

    }

}
