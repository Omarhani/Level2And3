package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class CheckOutPage extends MethodHandles {


    private By billingAddressContinueButton = By.name("save");

    private By shippingMethodContinueButton = By.id("shipping-method-please-wait");

    private By paymentMethodContinueButton = By.id("payment-method-please-wait");
    private By paymentInformationContinueButton = By.id("payment-info-please-wait");

    private By conFirmButton = By.xpath("//button[contains(text(),'Confirm')]");
    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnBillingAddressContinueButton(){
        click(billingAddressContinueButton);
    }
    public void clickOnShippingMethodContinueButton(){
        click(shippingMethodContinueButton);
    }
    public void clickOnPaymentMethodContinueButton(){
        click(paymentMethodContinueButton);
    }
    public void clickOnPaymentInformationContinueButton(){
        click(paymentMethodContinueButton);
    }

    public CompletePage clickOnConfirmButton(){
        click(conFirmButton);
        return new CompletePage(driver);
    }
}
