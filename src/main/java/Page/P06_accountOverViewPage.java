package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P06_accountOverViewPage extends pageBase{
    public P06_accountOverViewPage(WebDriver driver)
    {
        super(driver);
    }

    private final By overViewLink = By.cssSelector("div[id=\"leftPanel\"] ul :nth-child(2)");


    public void goToOverView()
    {
        clickEle(driver.findElement(overViewLink));
    }





}
