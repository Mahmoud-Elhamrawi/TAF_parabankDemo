package TestCases;

import Page.HomePage;
import Page.P01_RegisterPage;
import Page.P02_logOutPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC01_RegisterTest extends testBase{

    HomePage homePage ;
    P01_RegisterPage registerPage ;

    P02_logOutPage logOutPage ;

    @Test(priority = 1)
    public void RegisterActive()
    {
        homePage = new HomePage(driver);
        homePage.goTORegisterPage();
    }

    @Test(dependsOnMethods = "RegisterActive" , priority = 2)
    public void validRegister(){
        registerPage = new P01_RegisterPage(driver );
        Assert.assertEquals("Signing up is easy!",registerPage.assertTitleReg().getText());
        registerPage.fillRegisterForm("ahmed","ali","egypt","cairo","elharm","2525","01278385814","025","AliBenAhmed","123456");
        Assert.assertTrue(registerPage.assertOnWelcome().getText().contains("Welcome AliBenAhmed"));
    }


    @Test(priority = 3,dependsOnMethods = "validRegister")
    public void logOut()
    {
        logOutPage = new P02_logOutPage(driver);
        logOutPage.goTologOut();
        Assert.assertEquals("https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC",driver.getCurrentUrl());
    }


}
