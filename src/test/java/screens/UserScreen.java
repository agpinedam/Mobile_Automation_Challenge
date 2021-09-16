package screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserScreen extends BaseScreen{
    private final Logger log = LoggerFactory.getLogger(UserScreen.class);
    private final By watchList = By.id("com.imdb.mobile:id/your_watchlist_widget");
    private final By movieOnWatchList = By.id("com.imdb.mobile:id/main_line");

    public UserScreen(AndroidDriver driver) {
        super(driver);
    }

    public void waitForWatchList(){
        waitUntilVisibilityOfElement(watchList);
    }

    public String getMovieWatchList() {
        scrollToFindElement(movieOnWatchList);
        String movieName =getTexFromElement(movieOnWatchList);
        log.debug("The first movie in the list is " + movieName);
        return movieName;
    }
}
