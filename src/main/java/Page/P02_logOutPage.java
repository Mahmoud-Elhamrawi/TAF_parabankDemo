package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P02_logOutPage extends pageBase{
    public P02_logOutPage(WebDriver driver)
    {
        super(driver);
    }
    private final By logoutLink = By.linkText("Log Out");

    public void goTologOut()
    {
        clickEle(driver.findElement(logoutLink));
    }





}
