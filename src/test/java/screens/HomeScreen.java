package screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomeScreen extends BaseScreen{
    private final By featureToday = By.id("com.imdb.mobile:id/featured_today");
    private final Logger log = LoggerFactory.getLogger(HomeScreen.class);

    public HomeScreen(AndroidDriver driver) {
        super(driver);
    }

    public void waitForFeatureToday(){
        waitUntilVisibilityOfElement(featureToday);
        log.debug("Wait for visibility of Feature today");
    }
}
