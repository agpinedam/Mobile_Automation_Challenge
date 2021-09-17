package screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MovieScreen extends BaseScreen{
    private final By overview = By.id("com.imdb.mobile:id/plot_overview");
    private final By yourRate = By.id("com.imdb.mobile:id/empty_user_rating");
    private final By poster = By.id("com.imdb.mobile:id/title_poster");
    private final By movieName = By.id("com.imdb.mobile:id/title");
    private final By addWatchList =  By.id("com.imdb.mobile:id/watchlist_button_view");
    private final Logger log = LoggerFactory.getLogger(MovieScreen.class);

    public MovieScreen(AndroidDriver driver) {
        super(driver);
    }
    public String getOverview(){
        log.info("Get movie overview");
        return getTexFromElement(overview);
    }
    public void waitForVisibilityOfPoster(){
        waitUntilVisibilityOfElement(poster);
    }
    public void searchForUserReviews(){
        log.debug("Wait for Movie page");
        scrollToFindElement(yourRate);
    }
    public void clickAddReview(){
        clickOnElement(yourRate);
        log.info("Click on add review");
    }
    public String getMovieName(){
        log.debug("Get movie name");
        return getTexFromElement(movieName);
    }
    public void addWatchList(){
        scrollToFindElement(addWatchList);
        clickOnElement(addWatchList);
    }
}
