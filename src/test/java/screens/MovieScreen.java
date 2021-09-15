package screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MovieScreen extends BaseScreen{
    private final By overview = By.id("com.imdb.mobile:id/plot_overview");
    private final By addReview = By.id("com.imdb.mobile:id/add_review_parent");
    private final Logger log = LoggerFactory.getLogger(MovieScreen.class);

    public MovieScreen(AndroidDriver driver) {
        super(driver);
    }
    public String getOverview(){
        log.info("Get movie overview");
        return getTexFromElement(overview);
    }
    public void searchForUserReviews(){
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.debug("Wait for Movie page");
        scrollNumber(6);
    }
    public void clickAddReview(){
        clickOnElement(addReview);
        log.debug("Click on add review");
    }
}
