package screens;

import core.ConfigCapabilities;
import core.MobileAppDriver;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import screens.componets.BrowserBar;
import screens.popup.Location;
import screens.popup.RatedSaved;
import screens.popup.Tip;
import screens.popup.StayInformed;

public class Hooks {
    protected AndroidDriver driver;
    private final ConfigCapabilities configCapabilities = new ConfigCapabilities();
    private final MobileAppDriver mobileAppDriver = new MobileAppDriver();
    protected Location location;
    protected StayInformed stayInformed;
    protected LoginScreen loginScreen;
    protected HomeScreen homeScreen;
    protected BrowserBar browserBar;
    protected Tip tip;
    protected SearchScreen searchScreen;
    protected MovieScreen movieScreen;
    protected UserScreen userScreen;
    protected String randomMovieName;
    protected RatingScreen ratingScreen;
    protected RatedSaved ratedSaved;

    @BeforeSuite
    public void setup (){
        driver = mobileAppDriver.GetMoviesAppDriver(configCapabilities.GetCapabilities());
        location = new Location(driver);
        stayInformed = new StayInformed(driver);
        loginScreen = new LoginScreen(driver);
        homeScreen =new HomeScreen(driver);
        browserBar = new BrowserBar(driver);
        tip = new Tip(driver);
        searchScreen = new SearchScreen(driver);
        movieScreen = new MovieScreen(driver);
        userScreen = new UserScreen(driver);
        ratingScreen = new RatingScreen(driver);
        ratedSaved = new RatedSaved(driver);
        randomMovieName = "";
    }
    @BeforeTest
    public void skipAndLogin() {
        location.denyAccessLocation();
        stayInformed.acceptNotifications();
        loginScreen.loginWithGoogle();
        homeScreen.waitForFeatureToday();
        browserBar.clickOnSearchButton();
        tip.exitTip();
    }
}
