package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class P07_BillpayPage extends pageBase{

    public P07_BillpayPage(WebDriver driver)
    {
        super(driver);
    }


    private final By billLink = By.cssSelector("div[id=\"leftPanel\"] ul li:nth-child(4)");
    private final By assertTit = By.xpath("//div[@id=\"rightPanel\"] //h1[@class=\"title\" and text()=\"Bill Payment Service\"]");



    //inputs
    private final By payeeNameInp = By.cssSelector("input[name=\"payee.name\"]");
    private  final  By  addInp = By.cssSelector("input[name=\"payee.address.street\"]");
    private final By  cityInp = By.cssSelector("input[name=\"payee.address.city\"]");
    private final  By stateInp = By.cssSelector("input[name=\"payee.address.state\"]");
    private final  By zipInp = By.cssSelector("input[name=\"payee.address.zipCode\"]");
    private  final  By phoneInp = By.cssSelector("input[name=\"payee.phoneNumber\"]");
    private final  By accountInp = By.cssSelector("input[name=\"payee.accountNumber\"]");
    private final  By veifyaccountInp = By.cssSelector("input[name=\"verifyAccount\"]");
    private final  By amountInp = By.cssSelector("input[name=\"amount\"]");
    private final  By selAccountTag = By.cssSelector("select[name=\"fromAccountId\"]");
    private final By paymentBtn =  By.cssSelector("input[value=\"Send Payment\"]");

 //assertAfterPay
    private final  By waitAssert = By.cssSelector("div[ng-show=\"showResult\"]");
    private final By assertOnTit = By.cssSelector("div[id=\"rightPanel\"] div[ng-show=\"showResult\"] h1");
     private final  By assertOnAmount = By.id("amount");
    private final By assertOnAccount = By.id("fromAccountId");



    public void goToBillPage()
    {
        clickEle(driver.findElement(billLink));
    }
   public WebElement assertOnTitPag()
   {
       return driver.findElement(assertTit);
   }


   public void fillPaymentForm(String payName , String add , String city , String stat , String zcode , String pho , String account ,String amount)
   {
       EnterTxt(driver.findElement(payeeNameInp), payName);
       EnterTxt(driver.findElement(addInp), add);
       EnterTxt(driver.findElement(cityInp), city);
       EnterTxt(driver.findElement(stateInp), stat);
       EnterTxt(driver.findElement(zipInp), zcode);
       EnterTxt(driver.findElement(phoneInp), pho);
       EnterTxt(driver.findElement(accountInp), account);
       EnterTxt(driver.findElement(veifyaccountInp), account);
       EnterTxt(driver.findElement(amountInp), amount);
       Select sel = new Select(driver.findElement(selAccountTag)) ;
       sel.selectByIndex(2);
       clickEle(driver.findElement(paymentBtn));

   }


    public  WebElement waitAss()
    {
        return driver.findElement(waitAssert);
    }
    public WebElement assertAfterPayTitle()
    {
        return driver.findElement(assertOnTit);
    }


    public WebElement assertAfterAmount()
    {
        return driver.findElement(assertOnAmount);
    }

    public  WebElement assertAfterPayAcc()
    {
        return driver.findElement(assertOnAccount);
    }



}
