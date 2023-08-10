package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class ComputersPage extends MethodHandles {

    private By noteBooksLink = By.xpath("(//a[contains(text(),'Notebooks ')])[3]");
    public ComputersPage(WebDriver driver) {
        super(driver);
    }

    public NotBookPage clickOnNoteBookLink(){
        click(noteBooksLink);
        return new NotBookPage(driver);
    }
}
