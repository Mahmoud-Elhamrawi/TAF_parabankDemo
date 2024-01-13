package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P05_transferFundPage extends pageBase{
    public P05_transferFundPage(WebDriver driver) {
        super(driver);
    }
    private final By transferLink =By.cssSelector("div[id=\"leftPanel\"] ul :nth-child(3) a");
    private final By assertOnTit = By.cssSelector("div[id=\"rightPanel\"] h1");

    private final By transToChecking =  By.id("toAccountId");
    private final  By ammount = By.id("amount");
    private final By transferBtn =By.cssSelector("input[type=\"submit\"]");
    private final By assertOntransferTit = By.cssSelector("div[id=\"rightPanel\"] h1");
    private final By assertOnValue = By.cssSelector("table[id=\"accountTable\"] tr:nth-child(2) td:nth-child(3)");





    public void goToTanrsferPage()
    {
        clickEle(driver.findElement(transferLink));
    }
    public WebElement assertTit()
    {
        return driver.findElement(assertOnTit);
    }
   public WebElement transToCheckAcc()
   {
       return driver.findElement(transToChecking);
   }
   public WebElement typingAmount()
   {
       return driver.findElement(ammount);
   }


  public void transBtn()
  {
      clickEle(driver.findElement(transferBtn));
  }


  public WebElement assertAfterTransfer()
  {
      return driver.findElement(assertOntransferTit);
  }
  public WebElement assertValue()
  {
      return driver.findElement(assertOnValue);
  }







}
