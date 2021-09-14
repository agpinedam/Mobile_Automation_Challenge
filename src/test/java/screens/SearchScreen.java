package screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SearchScreen extends BaseScreen{
    private final By searchBar = By.id("com.imdb.mobile:id/search_src_text");
    private final By firstMovie = By.xpath("//androidx.recyclerview.widget" +
                                            ".RecyclerView/android.widget.LinearLayout[1]");
    private final Logger log = LoggerFactory.getLogger(SearchScreen.class);

    public SearchScreen(AndroidDriver driver) {
        super(driver);
    }
    public void typingOnSearchBar(String movieName){
        typingOnElement(searchBar,movieName);
        log.debug("Typing"+movieName+"on the Search Bar");
    }
    public void clickOnFirstResult(){
     clickOnElement(firstMovie);
     log.debug("Click the on the first Movie");
    }
}
