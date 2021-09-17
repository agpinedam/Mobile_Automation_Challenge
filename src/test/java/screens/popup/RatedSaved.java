package screens.popup;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import screens.BaseScreen;

public class RatedSaved extends BaseScreen {
    private final By messageText = By.id("com.imdb.mobile:id/title");
    private final By close = By.id("com.imdb.mobile:id/rate_more_like_this_close");
    private final Logger log = LoggerFactory.getLogger(RatedSaved.class);

    public RatedSaved(AndroidDriver driver) {
        super(driver);
    }
    public String getMessageText(){
        String message = getTexFromElement(messageText);
        log.debug("Get the rated saved message " + message);
        return message;
    }
    public void closeMessage(){
        clickOnElement(close);
        log.info("The message was closed");
    }
}
