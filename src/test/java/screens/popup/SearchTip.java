package screens.popup;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import screens.BaseScreen;

public class SearchTip extends BaseScreen {
    private final By exit = By.id("com.imdb.mobile:id/exit");
    private final Logger log = LoggerFactory.getLogger(SearchTip.class);

    public SearchTip(AndroidDriver driver) {
        super(driver);
    }
    public void exitTip(){
        clickOnElement(exit);
        log.debug("Click on x");
    }
}
