import org.testng.Assert;
import org.testng.annotations.Test;
import screens.Hooks;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;


public class TestIMDbApp extends Hooks {

    @Test
    public void verifyOverview() {
        browserBar.clickOnSearchButton();
        searchScreen.typingOnSearchBar("Fight Club");
        searchScreen.clickOnFirstSearchResult();
        Assert.assertEquals(movieScreen.getOverview(),
                "An insomniac office worker and a devil-may-care soap maker " +
                        "form an underground fight club that evolves into much more.");
    }
    @Test
    public void addMovieWatchList() {
        searchScreen.selectTopRatedCategory();
        searchScreen.addRandomMovie();
        randomMovieName = searchScreen.getRandomMovieName();
        browserBar.clickOnYouButton();
        tip.exitTip();
        userScreen.waitForWatchList();
        assertThat(randomMovieName,containsString(userScreen.getMovieWatchList()));
    }
    @Test
    public void rateAMovie(){
        browserBar.clickOnSearchButton();
        searchScreen.typingOnSearchBar("Citizen Kane");
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
