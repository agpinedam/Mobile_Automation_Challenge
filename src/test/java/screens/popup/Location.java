package screens.popup;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.FindBy;
import screens.BaseScreen;

public class Location extends BaseScreen {
    @FindBy(id = "com.android.permissioncontroller:id/permission_deny_button")
    private AndroidElement denyButton;

    public Location(AndroidDriver driver) {
        super(driver);
    }

    public void denyAccessLocation(){

    }
}
