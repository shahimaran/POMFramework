package baseClasses;

import PageClasses.LandingPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import utils.ExtentReportManager;

import java.util.concurrent.TimeUnit;

public class BaseTestClass {
    public WebDriver driver ;
    public ExtentReports report = ExtentReportManager.getReportInstance();
    public ExtentTest logger;

    /************************* Invoke Browser   ***************************************************/
    public void invokeBrowser(String browserName) {
        try {
            if (browserName.equalsIgnoreCase("Chrome")) {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\Drivers\\chromedriver.exe");
                driver = new ChromeDriver();
            } else if (browserName.equalsIgnoreCase("Mozila")) {
                System.setProperty("webdriver.gecko,driver", System.getProperty("user.dir") + "\\src\\main\\resources\\Drivers\\geckodriver.exe");
                driver = new FirefoxDriver();

            } else if (browserName.equalsIgnoreCase("Opera")) {
                System.setProperty("webdriver.opera,driver", System.getProperty("user.dir") + "\\src\\main\\resources\\Drivers\\operadriver.exe");
                driver = new OperaDriver();
            } else if (browserName.equalsIgnoreCase("IE")) {
                System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\Drivers\\IEDriverServer.exe");
                driver = new InternetExplorerDriver();

            } else if (browserName.equalsIgnoreCase("Edge")) {
                System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\Drivers\\msedgedriver.exe");
                driver = new EdgeDriver();
            } else {
                driver = new SafariDriver();
            }
        } catch (Exception e) {
            // reportFail(e.getMessage());
            System.out.println(e.getMessage());
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);


    }

    @AfterMethod
    public void flushReport(){
        report.flush();
        driver.close();
    }

    /***************** Wait Functions in Framework *****************/
    public void waitForPageLoad() {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        int i = 0;
        while (i != 180) {
            String pageState = (String) js.executeScript("return document.readyState;");
            if (pageState.equals("complete")) {
                break;
            } else {
                waitLoad(1);
            }
        }

        waitLoad(2);

        i = 0;
        while (i != 180) {
            Boolean jsState = (Boolean) js.executeScript("return window.jQuery != undefined && jQuery.active == 0;");
            if (jsState) {
                break;
            } else {
                waitLoad(1);
            }
        }
    }

    public void waitLoad(int i) {
        try {
            Thread.sleep(i * 1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}
