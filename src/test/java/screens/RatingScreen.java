package screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class RatingScreen extends BaseScreen{
    private final By rateButton = By.id("com.imdb.mobile:id/rate_title_button");
    private final Logger log = LoggerFactory.getLogger(RatingScreen.class);

    public RatingScreen(AndroidDriver driver) {
        super(driver);
    }
    public void clickOnAnyStartRate(){
        clickOnElement(randomRated());
        log.debug("Click on any start rated");
    }
    private By randomRated(){
        int randomNumber = (int) (Math.random() * 5 + 6);
        String id = "com.imdb.mobile:id/star_" + randomNumber;
        log.debug("Random rated "+randomNumber + " starts");
        return By.id(id);
    }
    public void clickOnRate(){
        clickOnElement(rateButton);
        log.debug("Click on rate button");
    }

}
