package screens;

import core.ConfigCapabilities;
import core.MobileAppDriver;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import screens.componets.BrowserBar;
import screens.popup.Location;
import screens.popup.SearchTip;
import screens.popup.StayInformed;

public class Hooks {
    protected AndroidDriver driver;
    private final ConfigCapabilities configCapabilities = new ConfigCapabilities();
    private final MobileAppDriver mobileAppDriver = new MobileAppDriver();
    protected Location location;
    protected StayInformed stayInformed;
    protected LoginScreen loginScreen;
    protected BrowserBar browserBar;
    protected SearchTip searchTip;
    protected SearchScreen searchScreen;
    protected MovieScreen movieScreen;

    @BeforeSuite
    public void setDriver(){
        driver = mobileAppDriver.GetMoviesAppDriver(configCapabilities.GetCapabilities());
        location = new Location(driver);
        stayInformed = new StayInformed(driver);
        loginScreen = new LoginScreen(driver);
        browserBar = new BrowserBar(driver);
        searchTip = new SearchTip(driver);
        searchScreen = new SearchScreen(driver);
        movieScreen = new MovieScreen(driver);
    }
    @BeforeTest
    public void skipAndLogin(){
        location.denyAccessLocation();
        stayInformed.acceptNotifications();
        loginScreen.loginWithGoogle();
        browserBar.clickOnSearchButton();
        searchTip.exitTip();
    }
}
