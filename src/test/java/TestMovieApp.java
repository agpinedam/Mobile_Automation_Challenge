import org.testng.Assert;
import org.testng.annotations.Test;
import screens.Hooks;


public class TestMovieApp extends Hooks {

    @Test
    public void verifyOverview() {
        browserBar.clickOnSearchButton();
        searchTip.exitTip();
        browserBar.clickOnSearchButton();
        searchScreen.typingOnSearchBar("Fight Club");
        searchScreen.clickOnFirstResult();
        Assert.assertEquals(movieScreen.getOverview(),
                "An insomniac office worker and a devil-may-care soap maker " +
                        "form an underground fight club that evolves into much more.");
    }


}
