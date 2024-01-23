package TestCases;

import Helper.screenShotFail;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class testBase {
    public WebDriver driver ;

    @BeforeClass
    @Parameters({"browser"})
    public void openingBrowser(@Optional("chrome") String browserName)
    {
        if(browserName.equalsIgnoreCase("chrome"))
        {
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }else if (browserName.equalsIgnoreCase("edge"))
        {
            driver =new EdgeDriver();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
        driver.get("https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC");

    }



    @AfterClass
    public void cleanUp() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @AfterMethod
    public void takingScreenShot(ITestResult result)
    {
    if(result.getStatus() == ITestResult.FAILURE)
        {
            System.out.println("fail...");
            System.out.println("taking screenshot.....");
            screenShotFail.capturescreenshot(driver,result.getName());

        }
    }


}
