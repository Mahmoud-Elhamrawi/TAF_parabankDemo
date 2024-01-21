package TestCases;

import Data.readJsonData;
import Page.*;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;



public class TC05_TransferFunds extends testBase{



    P03_LoginPage loginPage ;
    P05_transferFundPage transferFundPage ;
    P06_accountOverViewPage accountOverViewPage ;

    Data.readJsonData readJsonData ;

    @DataProvider(name = "jsonData")
    public Object[] testDataForRegister() throws IOException, ParseException {
        readJsonData = new readJsonData();
        return readJsonData.testDataForSuccessfulRegister();
    }
    @Test(dataProvider = "jsonData",priority = 1)
    public void login(String data) throws InterruptedException {
        String[] users = data.split(",");
        ///login
        loginPage = new P03_LoginPage(driver);
        loginPage.fillLoginForm(users[7], users[8]);
        Assert.assertEquals("Accounts Overview", loginPage.assertTit().getText());

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOf(loginPage.tableView()));
        Assert.assertEquals("Account", loginPage.assertOnContentOfHead().getText());
    }


    @Test(priority = 2,dependsOnMethods = "login")
    public void transferPage() throws InterruptedException {
        transferFundPage = new P05_transferFundPage(driver);
        transferFundPage.goToTanrsferPage();
        Assert.assertEquals("Transfer Funds", transferFundPage.assertTit().getText());
    }


    @Test(priority = 3,dependsOnMethods = "transferPage")
    public void transferChecking() throws InterruptedException {
        Thread.sleep(4000);
        Select sel = new Select(transferFundPage.transToCheckAcc());
        sel.selectByIndex(1);///checking nmber
        Thread.sleep(2000);
        transferFundPage.typingAmount().sendKeys( "100");

        transferFundPage.transBtn();

        WebDriverWait wait1 = new WebDriverWait(driver , Duration.ofSeconds(40));
        wait1.until(ExpectedConditions.visibilityOf(transferFundPage.assertAfterTransfer()));
        Thread.sleep(3000);
        Assert.assertEquals("Transfer Complete!",transferFundPage.assertAfterTransfer().getText());

        accountOverViewPage = new P06_accountOverViewPage(driver);
        accountOverViewPage.goToOverView();

        //assert on avaliable amount
        Thread.sleep(3000);
        Assert.assertEquals( "$200.00",transferFundPage.assertValue().getText());
        System.out.println(transferFundPage.assertValue().getText());

    }





    @Test(priority = 4,dependsOnMethods = "transferChecking",alwaysRun = false)
    public void transferSaving() throws InterruptedException {
        Thread.sleep(4000);
        Select sel = new Select(transferFundPage.transToCheckAcc());
        sel.selectByIndex(2);///checking nmber
        Thread.sleep(2000);
        transferFundPage.typingAmount().sendKeys( "100");

        transferFundPage.transBtn();

        WebDriverWait wait1 = new WebDriverWait(driver , Duration.ofSeconds(40));
        wait1.until(ExpectedConditions.visibilityOf(transferFundPage.assertAfterTransfer()));
        Thread.sleep(3000);
        Assert.assertEquals("Transfer Complete!",transferFundPage.assertAfterTransfer().getText());

        accountOverViewPage = new P06_accountOverViewPage(driver);
        accountOverViewPage.goToOverView();

        //assert on avaliable amount
        Thread.sleep(3000);
        Assert.assertEquals( "$100.00",transferFundPage.assertValue().getText());
        System.out.println(transferFundPage.assertValue().getText());

    }













}





























