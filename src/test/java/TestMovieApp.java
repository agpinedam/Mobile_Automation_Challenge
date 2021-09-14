import org.testng.Assert;
import org.testng.annotations.Test;
import screens.Hooks;
import screens.LoginScreen;
import screens.MovieScreen;
import screens.SearchScreen;
import screens.componets.BrowserBar;
import screens.popup.Location;
import screens.popup.SearchTip;
import screens.popup.StayInformed;

public class TestMovieApp extends Hooks {

    @Test
    public void prueba() {
        Location location = new Location(driver);
        location.denyAccessLocation();
        StayInformed stayInformed = new StayInformed(driver);
        stayInformed.acceptNotifications();
        LoginScreen loginScreen = new LoginScreen(driver);
        loginScreen.loginWithGoogle();
        BrowserBar browserBar = new BrowserBar(driver);
        browserBar.clickOnSearchButton();
        SearchTip searchTip = new SearchTip(driver);
        searchTip.exitTip();
        browserBar.clickOnSearchButton();
        SearchScreen searchScreen = new SearchScreen(driver);
        searchScreen.typingOnSearchBar("Fight Club");
        searchScreen.clickOnFirstResult();
        MovieScreen movieScreen = new MovieScreen(driver);
        Assert.assertEquals(movieScreen.getOverview(),
                "An insomniac office worker and a devil-may-care soap maker " +
                        "form an underground fight club that evolves into much more.");
    }


}
