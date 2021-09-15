package screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SearchScreen extends BaseScreen{
    private final By searchBar = By.id("com.imdb.mobile:id/search_src_text");
    private final By firstSearchMovie = By.xpath("//androidx.recyclerview.widget" +
                                            ".RecyclerView/android.widget.LinearLayout[1]");
    private final By topBoxOffice = By.id("com.imdb.mobile:id/top_box_office");
    private final By topRatedMovies = By.id("com.imdb.mobile:id/top_rated_movies");
    private final By mostPopularMovies = By.id("com.imdb.mobile:id/most_popular_movies");


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
    public void selectRandomCategory(){
        int randomNumber = (int) (Math.random() * 3 + 1);
        switch (randomNumber){
            case 1: {
                clickOnElement(topRatedMovies);
                log.debug("Selected top rated movies category");
                break;
            }
            case 2:{
                clickOnElement(topBoxOffice);
                log.debug("Selected top box office category");
                break;
            } default:{
                clickOnElement(mostPopularMovies);
                log.debug("Selected most popular movies category");
                break;
            }
        }
    }
    private By randomSelectorXPathAddMovie(){
        int randomNumber = (int) (Math.random() * 3 + 1);
        String xpath = "//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["
                +randomNumber+"]/android.widget.ImageView";
        log.debug("Generate xpath "+xpath);
        return By.xpath(xpath);
    }
    public void addRandomMovie(){
        clickOnElement(randomSelectorXPathAddMovie());
        log.debug("add random movie");
    }

}
