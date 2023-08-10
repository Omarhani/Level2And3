package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class LoginPage extends MethodHandles {

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    private By userNameField = By.id("Email");

    private By passwordFiled = By.id("Password");

    private By loginButton = By.cssSelector(".login-button");


    public void insertUsername(String username){
        sendKeys(userNameField,username);
    }

    public void insertPassword(String password){
        sendKeys(passwordFiled,password);
    }

    public void clickOnLoginButton(){
        click(loginButton);
    }
}
