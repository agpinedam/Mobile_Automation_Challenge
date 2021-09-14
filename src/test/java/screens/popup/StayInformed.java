package screens.popup;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import screens.BaseScreen;

public class StayInformed extends BaseScreen {
    private final By okButton = By.id("android:id/button2");
    private final Logger log = LoggerFactory.getLogger(StayInformed.class);

    public StayInformed(AndroidDriver driver) {
        super(driver);
    }

    public void acceptNotifications(){
        clickOnElement(okButton);
        log.debug("Click on accept notifications");
    }
}
