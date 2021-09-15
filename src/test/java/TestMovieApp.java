import org.testng.Assert;
import org.testng.annotations.Test;
import screens.Hooks;


public class TestMovieApp extends Hooks {

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
        searchScreen.selectRandomCategory();
        //searchScreen.selectRandomMovie();
        searchScreen.addRandomMovie();
    }


}
