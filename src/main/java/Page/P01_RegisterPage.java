package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P01_RegisterPage extends pageBase{
    public P01_RegisterPage(WebDriver driver) {
        super(driver);
    }
    private final By assertOnTitle = By.cssSelector("div[id=\"rightPanel\"] h1");
    private final By assertOnWelcomeReg = By.cssSelector("div[id=\"rightPanel\"] h1");
    public WebElement assertTitleReg()
    {
        return driver.findElement(assertOnTitle);
    }

    public WebElement assertOnWelcome()
    {
        return driver.findElement(assertOnWelcomeReg) ;
    }


    private final By firstName = By.id("customer.firstName");
    private final By lastName = By.id("customer.lastName");
    private final By address = By.id("customer.address.street");
    private final By city = By.id("customer.address.city");
    private final By state = By.id("customer.address.state");
    private final By zipcode = By.id("customer.address.zipCode");
    private final  By phone = By.id("customer.phoneNumber");
   private final By ssn = By.id("customer.ssn");
   private final By userName = By.id("customer.username");
   private final By password = By.id("customer.password");
   private final By confirmPass = By.id("repeatedPassword");
   private final By regBtn = By.cssSelector("form[id=\"customerForm\"] table  tr:nth-child(13) input");

   public void fillRegisterForm(String Fname , String Lname , String add , String cit , String stat ,String zip , String pho ,String sn ,String UN , String Pass)
   {
       EnterTxt(driver.findElement(firstName), Fname);
       EnterTxt(driver.findElement(lastName), Lname);
       EnterTxt(driver.findElement(address), add);
       EnterTxt(driver.findElement(city), cit);
       EnterTxt(driver.findElement(state), stat);
       EnterTxt(driver.findElement(zipcode), zip);
       EnterTxt(driver.findElement(phone), pho);
       EnterTxt(driver.findElement(ssn), sn);
       EnterTxt(driver.findElement(userName), UN);
       EnterTxt(driver.findElement(password), Pass);
       EnterTxt(driver.findElement(confirmPass),Pass );
       clickEle(driver.findElement(regBtn));

   }


}
