package screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.concurrent.TimeUnit;

public class BaseScreen {
    protected AndroidDriver driver;
    protected WebDriverWait wait;
    private final Logger log = LoggerFactory.getLogger(BaseScreen.class);

    public BaseScreen(AndroidDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,60);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    public void clickOnElement(By element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        log.debug("Wait for elements to be clickable");
        driver.findElement(element).click();
    }
    public void typingOnElement(By element, String typeElement){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        log.debug("Wait for typing an element");
        driver.findElement(element).sendKeys(typeElement);
    }
    public String getTexFromElement(By element){
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        return driver.findElement(element).getText();
    }
}
