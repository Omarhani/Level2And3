package login;

import base.BaseTests;
import data.ReadDataDrivenFromJson;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.IOException;

public class LoginTests1 extends BaseTests {

//    String username = "omarhani2627@gmail.com";
//    String password = "P@ssw0rd";

    @DataProvider
    public Object[] testDataFromSuccessfulLogin() throws IOException, ParseException {
        ReadDataDrivenFromJson readDataDrivenFromJson = new ReadDataDrivenFromJson();
        return readDataDrivenFromJson.readDataForSuccessfulLogin();
    }


    @Test(dataProvider = "testDataFromSuccessfulLogin")
    public void testSuccessfulLogin4(String data){
        String users[] = data.split(",");
        LoginPage loginPage = homePage.clickOnLoginLink();
        loginPage.insertUsername(users[0]);
        loginPage.insertPassword(users[1]);
        loginPage.clickOnLoginButton();
    }

}
