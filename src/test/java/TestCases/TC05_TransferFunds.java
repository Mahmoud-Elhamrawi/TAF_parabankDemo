package TestCases;

import Data.readJsonData;
import Page.*;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

import static TestCases.TC03_OpenNewAccountChecking.accNumchecking;
import static TestCases.TC04_OpenNewAccountSaving.accNumSaving;

public class TC05_TransferFunds extends testBase{




    P04_OpenAccountPage openAccountPage ;
    P02_logOutPage logOutPage ;
    P03_LoginPage loginPage ;
    P05_transferFundPage transferFundPage ;
    P06_accountOverViewPage accountOverViewPage ;

    Data.readJsonData readJsonData ;
    @DataProvider(name = "jsonData")
    public Object[] testDataForRegister() throws IOException, ParseException {
        readJsonData = new readJsonData();
        return readJsonData.testDataForSuccessfulRegister();
    }




    public void transfer(String type) throws InterruptedException {
        transferFundPage =new P05_transferFundPage(driver);
        transferFundPage.goToTanrsferPage();
        Assert.assertEquals("Transfer Funds",transferFundPage.assertTit().getText());
        Thread.sleep(3000);
          Select sel = new Select(transferFundPage.transToCheckAcc());
          sel.selectByVisibleText(type);///checking nmber


        Thread.sleep(2000);
        transferFundPage.typingAmount().sendKeys( "400");

        transferFundPage.transBtn();

        WebDriverWait wait1 = new WebDriverWait(driver , Duration.ofSeconds(40));
        wait1.until(ExpectedConditions.visibilityOf(transferFundPage.assertAfterTransfer()));
   Thread.sleep(3000);
        Assert.assertEquals("Transfer Complete!",transferFundPage.assertAfterTransfer().getText());

        accountOverViewPage = new P06_accountOverViewPage(driver);
        accountOverViewPage.goToOverView();

        //assert on avaliable amount
        Thread.sleep(3000);
        Assert.assertEquals( "$900.00",transferFundPage.assertValue().getText());

    }


    @Test(dataProvider = "jsonData" , alwaysRun = true)
    public void transferFund(String data) throws InterruptedException {
        String[] users = data.split(",");
         ///login
        loginPage = new P03_LoginPage(driver);
        loginPage.fillLoginForm(users[7],users[8]);
        Assert.assertEquals("Accounts Overview",loginPage.assertTit().getText());

        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOf(loginPage.tableView()));
        Assert.assertEquals("Account",loginPage.assertOnContentOfHead().getText());

        transfer("16896");
        transfer("17007");
         //transfer to checking
        /*
         transferFundPage =new P05_transferFundPage(driver);
         transferFundPage.goToTanrsferPage();
         Assert.assertEquals("Transfer Funds",transferFundPage.assertTit().getText());

//         Select sel = new Select(transferFundPage.transToCheckAcc());
//         sel.selectByValue("15120");///checking nmber

        transferFundPage.transToCheckAcc().sendKeys(accNumchecking);

         Thread.sleep(2000);
         transferFundPage.typingAmount().sendKeys( "400");

         transferFundPage.transBtn();

         WebDriverWait wait1 = new WebDriverWait(driver , Duration.ofSeconds(40));
         wait1.until(ExpectedConditions.visibilityOf(transferFundPage.assertAfterTransfer()));

         Assert.assertEquals("Transfer Complete!",transferFundPage.assertAfterTransfer().getText());

        accountOverViewPage = new P06_accountOverViewPage(driver);
        accountOverViewPage.goToOverView();

         //assert on avaliable amount
         Thread.sleep(3000);
         Assert.assertEquals( "$500.00",transferFundPage.assertValue().getText());

*/
         //transfer to saving
        /*
        transferFundPage.goToTanrsferPage();
        Assert.assertEquals("Transfer Funds",transferFundPage.assertTit().getText());
        transferFundPage.transToCheckAcc().sendKeys(accNumSaving);
        Thread.sleep(2000);
        transferFundPage.typingAmount().sendKeys( "400");

        transferFundPage.transBtn();
        wait1.until(ExpectedConditions.visibilityOf(transferFundPage.assertAfterTransfer()));

        Assert.assertEquals("Transfer Complete!",transferFundPage.assertAfterTransfer().getText());
        accountOverViewPage.goToOverView();

        //assert on avaliable amount
        Thread.sleep(3000);
        Assert.assertEquals( "$500.00",transferFundPage.assertValue().getText());

         */
    }




























}
