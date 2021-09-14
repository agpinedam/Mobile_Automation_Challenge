package screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MovieScreen extends BaseScreen{
    private final By overview = By.id("com.imdb.mobile:id/plot_overview");
    private final Logger log = LoggerFactory.getLogger(MovieScreen.class);

    public MovieScreen(AndroidDriver driver) {
        super(driver);
    }
    public String getOverview(){
        log.info("Get movie overview");
        return getTexFromElement(overview);
    }
}
