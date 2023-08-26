package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class CompletePage extends MethodHandles {


    private By thankYou = By.cssSelector(".page-title h1");
    public CompletePage(WebDriver driver) {
        super(driver);
    }

    public String getValidationMessage(){
        return getText(thankYou);
    }
}
