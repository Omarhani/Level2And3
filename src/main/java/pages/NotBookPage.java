package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class NotBookPage extends MethodHandles {

    private By addToCardButton = By.xpath("//button[contains(text(),'Add to cart')]");

    private By shoppingCartItem = By.cssSelector(".cart-qty");

    private By shoppingCartLink = By.cssSelector(".ico-cart");



    public NotBookPage(WebDriver driver) {
        super(driver);
    }
    public void clickOnAddTOCardButton(){
        click(addToCardButton);
    }

    public String getItems(){
        return getText(shoppingCartItem);
    }

    public ShoppingCartPage clickOnShoppingCartLink(){
        click(shoppingCartLink);
        return new ShoppingCartPage(driver);
    }

}
