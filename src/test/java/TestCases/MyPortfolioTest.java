package TestCases;

import PageClasses.LandingPage;
import PageClasses.MoneyPage;
import PageClasses.MyPortfolioPage;
import PageClasses.PortfolioLoginPAge;
import baseClasses.BaseTestClass;
import baseClasses.PageBaseClass;
import baseClasses.TopMenuClass;

import com.aventstack.extentreports.Status;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.TestDataProvider;

import java.util.Hashtable;


public class MyPortfolioTest extends BaseTestClass {

    LandingPage landingPage;
    MoneyPage moneyPage;
    PortfolioLoginPAge portfolioLoginPage;
    MyPortfolioPage myPortfolioPage;
    TopMenuClass topMenu;

    @Test(dataProvider = "getOpenPortfolioTestData")
    public void openPortfolio(Hashtable<String, String> testData) {
        logger = report.createTest("Loging Rediff Portfolio : " + testData.get("Comments"));

        invokeBrowser("Chrome");
        PageBaseClass pageBase = new PageBaseClass(driver, logger);
        PageFactory.initElements(driver, pageBase);

        landingPage = pageBase.OpenApplication();
        moneyPage = landingPage.clickMoneyLink();
        portfolioLoginPage = moneyPage.clickSigninLink();
        myPortfolioPage = portfolioLoginPage.doLogin(testData.get("UserName"), testData.get("Password"));
        myPortfolioPage.getPageTitle(testData.get("Page Title"));
        topMenu = myPortfolioPage.getTopMenu();
        topMenu.signOutApplication();

    }

    @Test(dataProvider = "verifyLoginTestData")
    public void verifyLogin(Hashtable<String, String> testData) {
        logger = report.createTest("Loging Rediff Portfolio : " + testData.get("Comments"));

        invokeBrowser("Chrome");
        PageBaseClass pageBase = new PageBaseClass(driver, logger);
        PageFactory.initElements(driver, pageBase);

        landingPage = pageBase.OpenApplication();
        moneyPage = landingPage.clickMoneyLink();
        portfolioLoginPage = moneyPage.clickSigninLink();
        myPortfolioPage = portfolioLoginPage.doLogin(testData.get("UserName"), testData.get("Password"));



    }

    @DataProvider
    public Object[][] verifyLoginTestData() {
        return TestDataProvider.getTestData("DemoPOM.xlsx", "RediffLoginTest", "VerifyLogin");
    }
    @DataProvider
    public Object[][] getOpenPortfolioTestData() {
        return TestDataProvider.getTestData("DemoPOM.xlsx", "RediffLoginTest", "Open Portfolio");
    }


    /*    @Test
    public void openPortfolio() {
        logger = report.createTest("Loging Rediff Portfolio");

        invokeBrowser("Chrome");
        PageBaseClass pageBase = new PageBaseClass(driver, logger);
        PageFactory.initElements(driver, pageBase);

        landingPage = pageBase.OpenApplication();

        moneyPage = landingPage.clickMoneyLink();

        portfolioLoginPage = moneyPage.clickSigninLink();

        myPortfolioPage = portfolioLoginPage.doLogin("imranshah.003@rediffmail.com", "Test@003");

        myPortfolioPage.getPageTitle("Rediff Moneywiz | My Portfolio(s)");

        topMenu = myPortfolioPage.getTopMenu();

        topMenu.signOutApplication();

    }
*/


//    @Test
//    public void openPortfolio() {
//        logger = report.createTest("Loging Rediff Portfolio");
//
//        invokeBrowser("Chrome");
//        PageBaseClass pageBase = new PageBaseClass(driver, logger);
//        PageFactory.initElements(driver, pageBase);
//        logger.log(Status.INFO, "Opening the Chrome Browser");
//
//        landingPage = pageBase.OpenApplication();
//        logger.log(Status.INFO, "Opening the Rediff Website");
//
//        moneyPage = landingPage.clickMoneyLink();
//        logger.log(Status.PASS, "Clicked the Money link Successfully");
//
//        portfolioLoginPage = moneyPage.clickSigninLink();
//        logger.log(Status.PASS, "Clicked Signin Link Successfully");
//
//        myPortfolioPage = portfolioLoginPage.doLogin("imranshah.003@rediffmail.com", "Test@003");
//        logger.log(Status.PASS, "Enter Username & Password Successfully");
//
//        myPortfolioPage.getPageTitle("Rediff Moneywiz | My Portfolio(s)");
//        logger.log(Status.PASS, "Pgae Title has been verified");
//
//        topMenu = myPortfolioPage.getTopMenu();
//        topMenu.signOutApplication();
//        logger.log(Status.PASS, "Signed_out the Application Successfully");
//
//
//    }
}
