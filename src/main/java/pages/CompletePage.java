package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class CompletePage extends MethodHandles {


    private By thankYou = By.tagName("h1");
    public CompletePage(WebDriver driver) {
        super(driver);
    }

    public void getValidationMessage(){
        getText(thankYou);
    }
}
