package baseClasses;


import PageClasses.LandingPage;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.DateUtils;
import java.io.File;
import java.io.IOException;


public class PageBaseClass extends BaseTestClass {

    public ExtentTest logger;
    public PageBaseClass(WebDriver driver, ExtentTest logger) {
        this.driver = driver;
        this.logger = logger;
    }

    /******************* Open Application **************************/
    public LandingPage OpenApplication() {
        logger.log(Status.INFO, "Opening the Website");
        driver.get("https://www.rediff.com/");
        logger.log(Status.PASS, "Successfully Opened the https://www.rediff.com/");

        // return PageFactory.initElements(driver, LandingPage.class);
        LandingPage landingPage = new LandingPage(driver,logger);
        PageFactory.initElements(driver,landingPage);
        return landingPage;
    }


    /******************* Get Page Title **************************/
    public void getPageTitle(String expectedTitle) {

        try {
            Assert.assertEquals(driver.getTitle(), expectedTitle);
            reportPass("Actual Title :" + driver.getTitle() + "--Equals to Expected Title: " + expectedTitle);
        } catch (Exception e) {
            reportFail(e.getMessage());
        }

    }

    public void verifyElementIsDisplayed(WebElement webElement){

        try {
            if (webElement.isDisplayed()){
                reportPass("UserName & Password Box is Displayed");
            }else {reportFail("UserName & Password Box is Not Displayed");}
        } catch (Exception e) {
            reportFail(e.getMessage());
        }


    }

    /*********** Reporting Function ***********************/

    public void reportFail(String reportString) {
        logger.log(Status.FAIL, reportString);
        takeScreenShotOnFailure();
        Assert.fail(reportString);
    }

    public void reportPass(String reportString) {
        logger.log(Status.PASS, reportString);
    }

    /****************** Capture Screen Shot ********************/

    public void takeScreenShotOnFailure() {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        File destinationFile = new File(System.getProperty("user.dir") + "\\ScreenShot\\" + DateUtils.getTimeStamp() + ".png");

        try {
            FileUtils.copyFile(sourceFile,destinationFile);
            logger.addScreenCaptureFromPath(System.getProperty("user.dir") + "\\ScreenShot\\" + DateUtils.getTimeStamp() + ".png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

