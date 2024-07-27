package PageClasses;

import baseClasses.PageBaseClass;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.sun.deploy.net.proxy.pac.PACFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends PageBaseClass {

    //constractor
    public LandingPage(WebDriver driver, ExtentTest logger) {
        super(driver, logger);

    }
    /*
    All WebElements of Landing Page and Associate operations
     */

//    public void openBrowser(){
//        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\Drivers\\chromedriver.exe");
//        driver = new ChromeDriver();
//
//    }

//    public void openWebSite(){
//        driver.get("https://www.rediff.com/");
//
//    }

//    public void clickSignIn(){}

    @FindBy(xpath = "//*[contains(@class,'moneyicon relative')]")
    public WebElement moneyLink;

    public MoneyPage clickMoneyLink() {
        logger.log(Status.INFO, "Clicking the Money Link, Present in header");
        moneyLink.click();
        logger.log(Status.PASS, "Clicked the Money Link");

        // return PageFactory.initElements(driver, MoneyPage.class);
        MoneyPage moneyPage = new MoneyPage(driver, logger);
        PageFactory.initElements(driver, moneyPage);
        return moneyPage;
    }

    public LoginPage clickSignIn() {
        //Perform the Click
        // return  new LoginPage();
        //return PageFactory.initElements(driver, LoginPage.class);
        LoginPage loginPage = new LoginPage(driver, logger);
        PageFactory.initElements(driver, logger);
        return loginPage;
    }


    //Open Browser Code
    //WebElements
    //Operations on WebElements


}
