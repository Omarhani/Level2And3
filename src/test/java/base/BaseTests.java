package base;

import data.ReadDataFromJsonFile;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;
import utils.EventReporter;
import utils.ScreenRecorderUtil;
import utils.UtilsTests;
import java.lang.reflect.Method;

public class BaseTests {

    private EventFiringWebDriver driver;
    protected HomePage homePage;
    UtilsTests utilsTests;

    protected ReadDataFromJsonFile readDataFromJsonFile;
    private final  String FILENAME = "testData.json";
    @Parameters("browser")
    private void setUpBrowser(String browser){
        // comment
        if (browser.equalsIgnoreCase("chrome")){
//            WebDriverManager.chromedriver().setup();
            driver = new EventFiringWebDriver(new ChromeDriver());
        }
        else if (browser.equalsIgnoreCase("firefox")) {
//            WebDriverManager.firefoxdriver().setup();
            driver = new EventFiringWebDriver(new FirefoxDriver());
        }
        else if (browser.equalsIgnoreCase("headlessChrome")){
//            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.setHeadless(true);
            driver = new EventFiringWebDriver(new ChromeDriver(options));
        }
        else if (browser.equalsIgnoreCase("headlessFirefox")){
//            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.setHeadless(true);
            driver = new EventFiringWebDriver(new FirefoxDriver(options));
        }
        driver.register(new EventReporter());
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }

    @BeforeClass
    @Parameters("browser")
    public void setUp(String browser) {
        setUpBrowser(browser);
    }


    @BeforeMethod
    public void goHome(Method method) throws Exception {
        readDataFromJsonFile = new ReadDataFromJsonFile(FILENAME);
        String URL = readDataFromJsonFile.jsonReader("URL");
        driver.get(URL);
        ScreenRecorderUtil.startRecord(method.getName());


    }
    @AfterMethod
    public void setStatus(Method method, ITestResult result) throws Exception {
        utilsTests = new UtilsTests(driver);
        utilsTests.statusOfTestCases(method,result);
        utilsTests.takeScreenShot(method.getName());
        ScreenRecorderUtil.stopRecord();

    }

//    @AfterClass
//    public void tearDown(){
//        driver.quit();
//    }

    @BeforeSuite
    public void startSuite(){
        utilsTests = new UtilsTests(driver);
        utilsTests.createReport();
    }
    @AfterSuite
    public void endSuite(){
        utilsTests = new UtilsTests(driver);
        utilsTests.flushReport();
    }


}
