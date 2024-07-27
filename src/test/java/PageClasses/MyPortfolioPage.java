package PageClasses;

import baseClasses.PageBaseClass;
import baseClasses.TopMenuClass;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MyPortfolioPage extends PageBaseClass {

    public TopMenuClass topMenu;
    ExtentTest logger;

    public MyPortfolioPage(WebDriver driver, ExtentTest logger) {
        super(driver, logger);

        topMenu = new TopMenuClass(driver, logger);
        PageFactory.initElements(driver, topMenu);
    }

    public TopMenuClass getTopMenu() {
        return topMenu;
    }
}
