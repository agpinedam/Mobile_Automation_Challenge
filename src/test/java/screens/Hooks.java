package screens;

import core.ConfigCapabilities;
import core.MobileAppDriver;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import screens.componets.BrowserBar;
import screens.popup.Location;
import screens.popup.Tip;
import screens.popup.StayInformed;

public class Hooks {
    protected AndroidDriver driver;
    private final ConfigCapabilities configCapabilities = new ConfigCapabilities();
    private final MobileAppDriver mobileAppDriver = new MobileAppDriver();
    protected Location location;
    protected StayInformed stayInformed;
    protected LoginScreen loginScreen;
    protected BrowserBar browserBar;
    protected Tip tip;
    protected SearchScreen searchScreen;
    protected MovieScreen movieScreen;
    protected UserScreen userScreen;
    protected String randomMovieName;

    @BeforeSuite
    public void setDriver(){
        driver = mobileAppDriver.GetMoviesAppDriver(configCapabilities.GetCapabilities());
        location = new Location(driver);
        stayInformed = new StayInformed(driver);
        loginScreen = new LoginScreen(driver);
        browserBar = new BrowserBar(driver);
        tip = new Tip(driver);
        searchScreen = new SearchScreen(driver);
        movieScreen = new MovieScreen(driver);
        userScreen = new UserScreen(driver);
        randomMovieName = "";
    }
    @BeforeTest
    public void skipAndLogin() {
        location.denyAccessLocation();
        stayInformed.acceptNotifications();
        loginScreen.loginWithGoogle();
        browserBar.clickOnSearchButton();
        tip.exitTip();
    }
}
