package TestCases;

import Helper.screenShotFail;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class testBase {
    public WebDriver driver ;

    @BeforeClass
    public void buildDriver()
    {
        driver = new ChromeDriver();
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
