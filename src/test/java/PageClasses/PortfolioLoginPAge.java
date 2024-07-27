package PageClasses;


import baseClasses.PageBaseClass;
import baseClasses.TopMenuClass;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PortfolioLoginPAge extends PageBaseClass {
    public TopMenuClass topMenu;

    public PortfolioLoginPAge(WebDriver driver, ExtentTest logger){
        super(driver,logger);

        topMenu = new TopMenuClass(driver, logger);
        PageFactory.initElements(driver, topMenu);
    }

    @FindBy(id="useremail")
    public WebElement useremail_TextBox;

    @FindBy(xpath="//*[@id='userpass']")
    public WebElement password_TextBox;

    @FindBy(xpath="//*[@id='loginsubmit']")
    public WebElement submitLogin_Btn;

    public MyPortfolioPage doLogin(String userName, String password) {
        useremail_TextBox.sendKeys(userName);
        logger.log(Status.PASS,"Enter the user name : " + userName);

        password_TextBox.sendKeys(password);
        logger.log(Status.PASS,"Enter the Password : " + password);

        submitLogin_Btn.click();
        logger.log(Status.PASS,"Enter submit button Successfully " );


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String currentPageTitle = driver.getTitle();
        if (currentPageTitle.equals("Indian stock markets: Login to Portfolio")){
            reportFail("Login is Fail on Portfolio Login page ");
            Assert.fail("Login Fail");
        }

        MyPortfolioPage myPortfolioPage = new MyPortfolioPage(driver,logger);
        PageFactory.initElements(driver,myPortfolioPage);
        return myPortfolioPage;
    }

    public void enterUseName(String userName){
        useremail_TextBox.sendKeys(userName);
        logger.log(Status.PASS,"Enter the user name : " + userName);
    }
    public void enterPassword(String password){
        password_TextBox.sendKeys();
        logger.log(Status.PASS,"Enter the Password : " + password);
    }
    public MyPortfolioPage submitLogin(){
        submitLogin_Btn.click();
        logger.log(Status.PASS,"Enter submit button Successfully " );

        MyPortfolioPage myPortfolioPage = new MyPortfolioPage(driver,logger);
        PageFactory.initElements(driver,myPortfolioPage);
        return myPortfolioPage;
    }

    public void verifyUserAndPasswordField(){
        verifyElementIsDisplayed(useremail_TextBox);
    }

}
