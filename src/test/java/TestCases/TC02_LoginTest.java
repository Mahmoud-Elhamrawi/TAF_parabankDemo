package TestCases;

import Data.readJsonData;
import Page.HomePage;
import Page.P03_LoginPage;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class TC02_LoginTest extends testBase{


    P03_LoginPage loginPage ;
    readJsonData  readJsonData ;
    @DataProvider(name = "jsonData")
    public Object[] testDataForRegister() throws IOException, ParseException {
        readJsonData = new readJsonData();
        return readJsonData.testDataForSuccessfulRegister();
    }

 @Test(dataProvider ="jsonData" )
    public void validLogin(String data)
 {
     String[] users = data.split(",");
     loginPage = new P03_LoginPage(driver);
     loginPage.fillLoginForm(users[7],users[8]);
     Assert.assertEquals("Accounts Overview",loginPage.assertTit().getText());
     WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(35));
     wait.until(ExpectedConditions.visibilityOf(loginPage.tableView()));
     Assert.assertEquals("Account",loginPage.assertOnContentOfHead().getText());

 }





}
