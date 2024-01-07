package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P03_LoginPage extends pageBase{
    public P03_LoginPage(WebDriver driver)
    {
        super(driver);
    }
    private final By userNameInp = By.cssSelector("input[name=\"username\"]");
    private final  By passwordInp = By.cssSelector("input[name=\"password\"]");
    private final By logibBtn = By.cssSelector("input[value=\"Log In\"]");
    private final By assertOnTitle = By.cssSelector("div[ng-app=\"OverviewAccountsApp\"] h1");
    private final By accountTable = By.id("accountTable");
    private final By contentOfThead = By.cssSelector("table[id=\"accountTable\"] th:nth-child(1)");



    public void fillLoginForm(String Un , String Pass)
    {
        EnterTxt(driver.findElement(userNameInp),Un );
        EnterTxt(driver.findElement(passwordInp),Pass );
        clickEle(driver.findElement(logibBtn));

    }


    public WebElement assertTit()
  {
      return driver.findElement(assertOnTitle);
  }
  public WebElement tableView()
  {
      return driver.findElement(accountTable);
  }
 public WebElement assertOnContentOfHead()
 {
     return driver.findElement(contentOfThead);
 }




}
