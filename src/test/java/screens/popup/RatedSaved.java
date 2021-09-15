package screens.popup;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import screens.BaseScreen;

public class RatedSaved extends BaseScreen {
    private final By message = By.id("com.imdb.mobile:id/title");
    private final Logger log = LoggerFactory.getLogger(RatedSaved.class);

    public RatedSaved(AndroidDriver driver) {
        super(driver);
    }
    public String message(){
        log.debug("Get the rated saved message");
        return getTexFromElement(message);
    }
}
