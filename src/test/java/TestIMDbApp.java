import org.testng.Assert;
import org.testng.annotations.Test;
import screens.Hooks;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;


public class TestIMDbApp extends Hooks {

    @Test
    public void verifyOverview() {
        browserBar.clickOnSearchButton();
        searchScreen.typingOnSearchBar(movieName);
        searchScreen.clickOnFirstSearchResult();
        assertThat(movieScreen.getOverview(),containsString(movieOverview));
    }
    @Test
    public void addMovieWatchList() {
        searchScreen.typingOnSearchBar(movieName);
        searchScreen.addRandomMovie();
        randomMovieName = movieScreen.getMovieName();
        movieScreen.addWatchList();
        browserBar.clickOnYouButton();
        tip.exitTip();
        userScreen.waitForWatchList();
        assertThat(randomMovieName,containsString(userScreen.getMovieWatchList()));
    }
    @Test
    public void rateAMovie(){
        browserBar.clickOnSearchButton();
        searchScreen.typingOnSearchBar(movieName);
        searchScreen.clickOnFirstSearchResult();
        movieScreen.waitForVisibilityOfPoster();
        movieScreen.searchForUserReviews();
        movieScreen.clickAddReview();
        ratingScreen.clickOnAnyStartRate();
        ratingScreen.clickOnRate();
        assertThat(ratedSaved.getMessageText(),containsString("Rating saved"));
        ratedSaved.closeMessage();
    }
}
