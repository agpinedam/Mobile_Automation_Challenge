package screens.popup;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import screens.BaseScreen;

public class Location extends BaseScreen {
    private final By denyButton = By.id("com.android.permissioncontroller:id/permission_deny_button");
    private final Logger log = LoggerFactory.getLogger(Location.class);

    public Location(AndroidDriver driver) {
        super(driver);
    }

    public void denyAccessLocation(){
        clickOnElement(denyButton);
        log.debug("Click on deny access location");
    }
}
