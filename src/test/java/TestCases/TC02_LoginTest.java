package TestCases;

import Page.HomePage;
import Page.P03_LoginPage;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC02_LoginTest extends testBase{

 HomePage homePage ;
 P03_LoginPage loginPage ;

 @Test
    public void validLogin()
 {
     loginPage = new P03_LoginPage(driver);
     loginPage.fillLoginForm("AliBenAhmed","123456");
     Assert.assertEquals("Accounts Overview",loginPage.assertTit().getText());

     WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(35));
     wait.until(ExpectedConditions.visibilityOf(loginPage.tableView()));
     Assert.assertEquals("Account",loginPage.assertOnContentOfHead().getText());


 }





}
