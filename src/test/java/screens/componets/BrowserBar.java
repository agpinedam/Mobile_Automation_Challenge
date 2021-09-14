package screens.componets;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import screens.BaseScreen;

public class BrowserBar extends BaseScreen {
    private final By searchBar = By.id("com.imdb.mobile:id/navigation_search_browse");

    public BrowserBar(AndroidDriver driver) {
        super(driver);
    }
    public void clickOnSearchButton(){
        clickOnElement(searchBar);
    }
}
