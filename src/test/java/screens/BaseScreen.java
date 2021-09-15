package screens;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.appium.java_client.TouchAction;


import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseScreen {
    protected AndroidDriver driver;
    protected WebDriverWait wait;
    private final Logger log = LoggerFactory.getLogger(BaseScreen.class);

    protected BaseScreen(AndroidDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,120);
    }

    protected void clickOnElement(By element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        log.debug("Wait for elements to be clickable");
        driver.findElement(element).click();
    }
    protected void typingOnElement(By element, String typeElement){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        log.debug("Wait for typing an element");
        driver.findElement(element).sendKeys(typeElement);
    }
    protected String getTexFromElement(By element){
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        return driver.findElement(element).getText();
    }
    protected void scrollNumber(int numberOfScrolling){
        for (int i = 0; i < numberOfScrolling; i++){
            scroll();
            log.debug("Scrolling");
        }
    }
    protected void scroll(){
        Dimension dimension = driver.manage().window().getSize();
        int start_x = (int) (dimension.width * 0.5);
        int start_y = (int) (dimension.height * 0.8);

        int end_x = (int) (dimension.width * 0.5);
        int end_y = (int) (dimension.height * 0.1);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(start_x,start_y))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(end_x,end_y)).release().perform();

    }
    public void implicitWait(int time){
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }
}
