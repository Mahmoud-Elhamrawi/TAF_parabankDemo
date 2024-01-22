package TestCases;

import Data.readDataBillPay;
import Data.readDataUser;
import Page.P02_logOutPage;
import Page.P03_LoginPage;
import Page.P07_BillpayPage;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class TC06_BillpayTest extends testBase{
    readDataBillPay readDataBill;
    readDataUser readDataUser ;
    P03_LoginPage loginPage ;
    P07_BillpayPage billpayPage ;
    P02_logOutPage logOutPage ;

    @DataProvider(name = "jsonData")
    public Object[] testDataForRegister() throws IOException, ParseException {
        readDataUser = new readDataUser();
        return readDataUser.testDataForSuccessfulRegister();

    }
    @Test(dataProvider = "jsonData",priority = 1)
    public void login(String data) {
        String[] users = data.split(",");
        ///login
        loginPage = new P03_LoginPage(driver);
        loginPage.fillLoginForm(users[7], users[8]);
        Assert.assertEquals("Accounts Overview", loginPage.assertTit().getText());

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOf(loginPage.tableView()));
        Assert.assertEquals("Account", loginPage.assertOnContentOfHead().getText());
    }



    @Test(priority = 2, dependsOnMethods = "login")
    public void goToBillPayPage()
    {
        billpayPage = new P07_BillpayPage(driver);
        billpayPage.goToBillPage();
        Assert.assertEquals("Bill Payment Service",billpayPage.assertOnTitPag().getText());
    }






    @DataProvider(name = "payment")
    public Object[] testDataForPayBill() throws IOException, ParseException {
        readDataBill = new readDataBillPay();
        return readDataBill.testDataForSuccessfulPayBill() ;
    }
    @Test(dataProvider = "payment" , dependsOnMethods = "goToBillPayPage" ,priority = 3)
    public void paymentProcess(String BillData) throws InterruptedException {
        String[] bill = BillData.split(",");
        billpayPage = new P07_BillpayPage(driver);
        billpayPage.fillPaymentForm(bill[0],bill[1],bill[2],bill[3],bill[4],bill[5],bill[6],bill[7]);


        WebDriverWait wait = new WebDriverWait(driver ,Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOf(billpayPage.waitAss()));

        Assert.assertEquals("Bill Payment Complete",billpayPage.assertAfterPayTitle().getText());
        System.out.println(billpayPage.assertAfterPayTitle().getText());

        Assert.assertEquals("$200.00",billpayPage.assertAfterAmount().getText());
        System.out.println(billpayPage.assertAfterAmount().getText());


//        Assert.assertEquals("$200.00",billpayPage.assertAfterPayAcc().getText());
        System.out.println(billpayPage.assertAfterPayAcc().getText());

    }



    @Test(priority = 4,dependsOnMethods = "paymentProcess")
    public void logOut()
    {
        logOutPage = new P02_logOutPage(driver);
        logOutPage.goTologOut();
        Assert.assertEquals("https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC",driver.getCurrentUrl());
    }













}
