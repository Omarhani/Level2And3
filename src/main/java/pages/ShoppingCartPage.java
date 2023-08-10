package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class ShoppingCartPage extends MethodHandles {

    private By termsAndServiceAgreeButton = By.id("termsofservice");

    private By checkOutButton = By.id("checkout");
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnTermsAndServiceAgreeButton(){
        click(termsAndServiceAgreeButton);
    }
    public CheckOutPage clickOnCheckOutButton(){
        click(checkOutButton);
        return new CheckOutPage(driver);
    }
}
