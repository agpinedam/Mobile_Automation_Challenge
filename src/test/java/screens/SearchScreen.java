package screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SearchScreen extends BaseScreen{
    private final By searchBar = By.id("com.imdb.mobile:id/search_src_text");
    private final By firstSearchMovie = By.xpath("//androidx.recyclerview.widget" +
                                            ".RecyclerView/android.widget.LinearLayout[1]");
    private final Logger log = LoggerFactory.getLogger(SearchScreen.class);

    public SearchScreen(AndroidDriver driver) {
        super(driver);
    }
    public void typingOnSearchBar(String movieName){
        typingOnElement(searchBar,movieName);
        log.debug("Typing "+movieName+" on the Search Bar");
    }
    public void clickOnFirstSearchResult(){
     clickOnElement(firstSearchMovie);
     log.debug("Click the on the first Movie");
    }
    private String randomSelectorXPathAddMovie(){
        int randomNumber = generateRandomData.randomInteger(1,2);
        String randomXPathBase = "//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout["
                + randomNumber + "]";
        log.debug("Generate random xpath base"+ randomXPathBase);
        return randomXPathBase;
    }
    public void addRandomMovie(){
        By xpath = By.xpath(randomSelectorXPathAddMovie()+"/android.widget.ImageView");
        clickOnElement(xpath);
        log.debug("add random movie");
    }
}
