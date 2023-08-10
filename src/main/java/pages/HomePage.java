package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class HomePage extends MethodHandles {


    public HomePage(WebDriver driver) {
        super(driver);
    }
    private By loginLink = By.cssSelector(".ico-login");

    private By computersLink = By.xpath("//a[contains(text(),'Computers')]");




    public LoginPage clickOnLoginLink(){
        click(loginLink);
        return new LoginPage(driver);
    }
    public ComputersPage clickOnComputersLink(){
        click(computersLink);
        return new ComputersPage(driver);
    }

}
