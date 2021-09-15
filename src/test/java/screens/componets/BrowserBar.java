package screens.componets;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import screens.BaseScreen;

public class BrowserBar extends BaseScreen {
    private final By searchButton = By.id("com.imdb.mobile:id/navigation_search_browse");
    private final By youButton = By.id("com.imdb.mobile:id/navigation_you");
    private final Logger log = LoggerFactory.getLogger(BrowserBar.class);

    public BrowserBar(AndroidDriver driver) {
        super(driver);
    }
    public void clickOnSearchButton(){
        clickOnElement(searchButton);
        log.debug("Click on search button");
    }
    public void clickOnYouButton(){
        clickOnElement(youButton);
        log.debug("Click on You button");
    }
}
