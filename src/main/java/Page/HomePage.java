package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends pageBase{
    public HomePage(WebDriver driver) {
        super(driver);
    }


    private final By registerLink = By.linkText("Register");





    public void goTORegisterPage()
    {
        clickEle(driver.findElement(registerLink));
    }



}
