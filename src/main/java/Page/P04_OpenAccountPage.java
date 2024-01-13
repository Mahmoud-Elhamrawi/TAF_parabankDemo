package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P04_OpenAccountPage extends pageBase{

 public P04_OpenAccountPage(WebDriver driver)
 {
     super(driver);
     this.driver = driver ;

 }

 private final By openAccountLink = By.cssSelector("div[id=\"leftPanel\"] :nth-child(1) >a");
 private final  By assertOnTitle = By.cssSelector("div[id=\"rightPanel\"] h1");
 private final By accountMain = By.id("fromAccountId");

 private final By createBtn = By.cssSelector("input[class=\"button\"]");
 private final By assertOnShowResult = By.id("rightPanel");
 private final By assertAfterCreate = By.cssSelector("div[id=\"rightPanel\"] div h1");
    ///accountSaving
    private final By selSavingTag =By.id("type");

  private final By accountNumber= By.xpath("//a[@id=\"newAccountId\"]");




    public void goToAccountPageCreation()
 {
     clickEle(driver.findElement(openAccountLink));
 }
    public WebElement assetTitle()
 {
     return driver.findElement(assertOnTitle);
 }
     public WebElement myAccountMain()
 {
     return  driver.findElement(accountMain);
 }
    public void createAccount()
 {
     clickEle(driver.findElement(createBtn));
 }
    public WebElement assertOnShowRes()
  {
      return driver.findElement(assertOnShowResult);
  }
     public WebElement assertAccountOpened()
    {
        return  driver.findElement(assertAfterCreate);
    }


    public WebElement savingAcc()
    {
        return driver.findElement(selSavingTag);
    }

    public WebElement numberAcc()
    {
        return driver.findElement(accountNumber);
    }
}
