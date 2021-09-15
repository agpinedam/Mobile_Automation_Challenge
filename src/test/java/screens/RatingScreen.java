package screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;


public class RatingScreen extends BaseScreen{
    public RatingScreen(AndroidDriver driver) {
        super(driver);
    }
    public void clickOnAnyStartRate(){
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clickOnElement(randomRated());
    }

    private By randomRated(){
        String xpath = "//*[@id=\"screenshotContainer\"]/div/div/div/div/div/div[29]";
        return By.xpath(xpath);
    }

}
