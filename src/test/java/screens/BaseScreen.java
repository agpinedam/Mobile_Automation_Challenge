package screens;

import core.ConfigCapabilities;
import core.MobileAppDriver;
import io.appium.java_client.android.AndroidDriver;

public class BaseScreen {
    private final ConfigCapabilities configCapabilities = new ConfigCapabilities();
    private final MobileAppDriver mobileAppDriver = new MobileAppDriver();
    protected AndroidDriver driver;

    public BaseScreen(AndroidDriver driver) {
        this.driver = driver;
    }
}
