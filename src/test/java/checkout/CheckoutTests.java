package checkout;

import base.BaseTests;
import data.ReadDataDrivenFromJson;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;

import java.io.IOException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CheckoutTests extends BaseTests {

    @DataProvider
    public Object[] testDataFromSuccessfulLogin() throws IOException, ParseException {
        ReadDataDrivenFromJson readDataDrivenFromJson = new ReadDataDrivenFromJson();
        return readDataDrivenFromJson.readDataForSuccessfulLogin();
    }

    @Test(dataProvider ="testDataFromSuccessfulLogin")
    public void testCheckOut(String data) throws InterruptedException {
        String user[] = data.split(",");
        LoginPage loginPage = homePage.clickOnLoginLink();
        HomePage homePage1 = loginPage.loginFeature(user[0],user[1]);
        ComputersPage computersPage = homePage1.clickOnComputersLink();
        NotBookPage notBookPage = computersPage.clickOnNoteBookLink();
        notBookPage.clickOnItemLink();
        notBookPage.clickOnAddTOCardButton();
        ShoppingCartPage shoppingCartPage = notBookPage.clickOnShoppingCartLink();
        shoppingCartPage.clickOnTermsAndServiceAgreeButton();
        CheckOutPage checkOutPage = shoppingCartPage.clickOnCheckOutButton();
        checkOutPage.clickOnBillingAddressContinueButton();
        checkOutPage.clickOnShippingMethodContinueButton();
        checkOutPage.clickOnPaymentMethodContinueButton();
        checkOutPage.clickOnPaymentInformationContinueButton();
        CompletePage completePage = checkOutPage.clickOnConfirmButton();
        Thread.sleep(3000);
        assertEquals(completePage.getValidationMessage(),"Thank you");




    }
}
