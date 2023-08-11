package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MethodHandles {

    public WebDriver driver;
    WebDriverWait wait;

    public MethodHandles(WebDriver driver){
        this.driver = driver;
    }
    protected void click(By locator){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
//        scrollToElement(driver,locator);
        driver.findElement(locator).click();
    }
    protected void sendKeys(By locator,String text){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
//        scrollToElement(driver,locator);
        driver.findElement(locator).sendKeys(text);
    }
    protected String getText(By locator){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
//        scrollToElement(driver,locator);
        return driver.findElement(locator).getText();
    }

    private void scrollToElement(WebDriver driver, By locator){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(locator));
    }
}
