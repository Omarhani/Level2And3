package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class CheckOutPage extends MethodHandles {


    private By billingAddressContinueButton = By.name("save");

    private By shippingMethodContinueButton = By.cssSelector(".button-1.shipping-method-next-step-button");

    private By paymentMethodContinueButton = By.cssSelector(".button-1.payment-method-next-step-button");
    private By paymentInformationContinueButton = By.cssSelector(".button-1.payment-info-next-step-button");

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
        click(paymentInformationContinueButton);
    }

    public CompletePage clickOnConfirmButton(){
        click(conFirmButton);
        return new CompletePage(driver);
    }
}
