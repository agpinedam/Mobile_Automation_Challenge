package screens;

import core.ConfigCapabilities;
import core.MobileAppDriver;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.BeforeClass;

public class Hooks {
    protected AndroidDriver driver;
    private final ConfigCapabilities configCapabilities = new ConfigCapabilities();
    private final MobileAppDriver mobileAppDriver = new MobileAppDriver();

    @BeforeClass
    public void setDriver(){
        driver = mobileAppDriver.GetMoviesAppDriver(configCapabilities.GetCapabilities());
    }
}
