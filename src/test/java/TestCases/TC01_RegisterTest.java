package TestCases;

import Data.readJsonData;
import Page.HomePage;
import Page.P01_RegisterPage;
import Page.P02_logOutPage;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC01_RegisterTest extends testBase{

    HomePage homePage ;
    P01_RegisterPage registerPage ;

    P02_logOutPage logOutPage ;
    readJsonData  readJsonData ;

    @DataProvider(name = "jsonData")
    public Object[] testDataForRegister() throws IOException, ParseException {
        readJsonData = new readJsonData();
        return readJsonData.testDataForSuccessfulRegister();
    }

    @Test(priority = 1)
    public void RegisterActive()
    {
        homePage = new HomePage(driver);
        homePage.goTORegisterPage();
    }

    @Test( dataProvider = "jsonData", priority = 2,dependsOnMethods = "RegisterActive")
    public void validRegister(String data){
        String[] users = data.split(",");
        registerPage = new P01_RegisterPage(driver );
        Assert.assertEquals("Signing up is easy!",registerPage.assertTitleReg().getText());
        registerPage.fillRegisterForm(users[0],users[1],users[2],users[3],users[4],users[5],users[6],users[6],users[7],users[8]);
        Assert.assertTrue(registerPage.assertOnWelcome().getText().contains("Welcome "+users[7]));

    }


    @Test(priority = 3,dependsOnMethods = "validRegister")
    public void logOut()
    {
        logOutPage = new P02_logOutPage(driver);
        logOutPage.goTologOut();
        Assert.assertEquals("https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC",driver.getCurrentUrl());
    }


}
