package screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SearchScreen extends BaseScreen{
    private final By searchBar = By.id("com.imdb.mobile:id/search_src_text");
    private final By firstSearchMovie = By.xpath("//androidx.recyclerview.widget" +
                                            ".RecyclerView/android.widget.LinearLayout[1]");
    private final By topRatedMovies = By.id("com.imdb.mobile:id/top_rated_movies");
    private String randomXPathBase;
    private final Logger log = LoggerFactory.getLogger(SearchScreen.class);

    public SearchScreen(AndroidDriver driver) {
        super(driver);
    }
    public void typingOnSearchBar(String movieName){
        typingOnElement(searchBar,movieName);
        log.debug("Typing"+movieName+"on the Search Bar");
    }
    public void clickOnFirstSearchResult(){
     clickOnElement(firstSearchMovie);
     log.debug("Click the on the first Movie");
    }
    public void selectTopRatedCategory(){
        clickOnElement(topRatedMovies);
        log.debug("Selected most popular movies category");
    }
    private String randomSelectorXPathAddMovie(){
        int randomNumber = (int) (Math.random() * 3 + 1);
        randomXPathBase = "//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["
                +randomNumber+"]";
        log.debug("Generate random xpath base"+ randomXPathBase);
        return randomXPathBase;
    }
    public void addRandomMovie(){
        By xpath = By.xpath(randomSelectorXPathAddMovie()+"/android.widget.ImageView");
        clickOnElement(xpath);
        log.debug("add random movie");
    }
    public String getRandomMovieName(){
        By xpath = By.xpath(randomXPathBase+"/android.view.ViewGroup/android.widget.TextView");
        String name = getTexFromElement(xpath);
        log.debug("Name of random movie "+name);
        return name;
    }
}
