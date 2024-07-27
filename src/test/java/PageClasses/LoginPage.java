package PageClasses;


import baseClasses.PageBaseClass;
import baseClasses.TopMenuClass;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends PageBaseClass {

    public TopMenuClass topMenu;
    public ExtentTest logger;

    public LoginPage(WebDriver driver, ExtentTest logger) {
        super(driver, logger);
        topMenu = new TopMenuClass(driver, logger);
        PageFactory.initElements(driver, TopMenuClass.class);

    }

    //WebElements on Login Page
    //Functions associated with Login Page

    public RediffMailPage doLogin() {
        //perform the Login
        //return PageFactory.initElements(driver, RediffMailPage.class);
        //else if login fails
        // return new LoginPage();
        RediffMailPage rediffMailPage = new RediffMailPage(driver, logger);
        PageFactory.initElements(driver, rediffMailPage);
        return rediffMailPage;
    }

    public TopMenuClass getTopMenu() {
        return topMenu;
    }

    public void getTitle() {

    }
}