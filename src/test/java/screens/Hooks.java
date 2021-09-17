package screens;

import core.ConfigCapabilities;
import core.MobileAppDriver;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.*;
import screens.componets.BrowserBar;
import screens.popup.Location;
import screens.popup.RatedSaved;
import screens.popup.Tip;
import screens.popup.StayInformed;
import utils.GenerateRandomData;
import utils.PropertiesReader;

public class Hooks {
    protected AndroidDriver driver;
    private final ConfigCapabilities configCapabilities = new ConfigCapabilities();
    private final MobileAppDriver mobileAppDriver = new MobileAppDriver();
    protected PropertiesReader propertiesReader;
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
    protected String movieName;
    protected String movieOverview;
    public GenerateRandomData generateRandomData;

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
        generateRandomData = new GenerateRandomData();
    }
    @BeforeTest
    public void skipAndLogin() {
        location.denyAccessLocation();
        stayInformed.acceptNotifications();
        loginScreen.loginWithGoogle();
        homeScreen.waitForFeatureToday();
        browserBar.clickOnSearchButton();
        tip.exitTip();
        browserBar.clickOnSearchButton();
    }
    @BeforeMethod
    public void getAMovieName(){
        propertiesReader = PropertiesReader.getInstance(generateRandomData.randomInteger(1,5));
        movieName = propertiesReader.getMovieName();
        movieOverview = propertiesReader.getOverview();
    }
    @AfterMethod
    public void goHomeScreen(){
        browserBar.goHome();
        homeScreen.waitForFeatureToday();
        browserBar.clickOnSearchButton();
        browserBar.clickOnSearchButton();
    }
    @AfterTest
    public void closeApp(){
        driver.closeApp();
    }
}
