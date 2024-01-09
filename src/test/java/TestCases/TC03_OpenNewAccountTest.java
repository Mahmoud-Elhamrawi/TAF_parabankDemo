package TestCases;

import Data.readJsonData;
import Page.HomePage;
import Page.P03_LoginPage;
import Page.P04_OpenAccountPage;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class TC03_OpenNewAccountTest  extends testBase{


    P04_OpenAccountPage openAccountPage ;

    P03_LoginPage loginPage ;

    Data.readJsonData readJsonData ;
    @DataProvider(name = "jsonData")
    public Object[] testDataForRegister() throws IOException, ParseException {
        readJsonData = new readJsonData();
        return readJsonData.testDataForSuccessfulRegister();
    }


    @Test(dataProvider = "jsonData")
    public void createNewAccount(String data) throws InterruptedException {
        //login
        String[] users = data.split(",");
        loginPage = new P03_LoginPage(driver);
        loginPage.fillLoginForm(users[7],users[8]);
        Assert.assertEquals("Accounts Overview",loginPage.assertTit().getText());

        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOf(loginPage.tableView()));
        Assert.assertEquals("Account",loginPage.assertOnContentOfHead().getText());

        openAccountPage = new P04_OpenAccountPage(driver);
        openAccountPage.goToAccountPageCreation();
        System.out.println(openAccountPage.assetTitle().getText());
        Assert.assertEquals("Open New Account",openAccountPage.assetTitle().getText());

        wait.until(ExpectedConditions.visibilityOf(openAccountPage.myAccountMain()));
        Thread.sleep(3000);
        openAccountPage.createAccount();
        Thread.sleep(3000);
        System.out.println(openAccountPage.assertAccountOpened().getText());
//        wait.until(ExpectedConditions.visibilityOf(openAccountPage.assertOnShowRes()));
        Assert.assertEquals("Account Opened!" , openAccountPage.assertAccountOpened().getText());



    }





}
