import core.ConfigCapabilities;
import core.MobileAppDriver;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TestMovieApp {

    @Test
    public void prueba(){
        ConfigCapabilities configCapabilities = new ConfigCapabilities();
        //System.out.println(configCapabilities.GetCapabilities());
        MobileAppDriver mobileAppDriver = new MobileAppDriver();
        AndroidDriver driver = mobileAppDriver.GetMoviesAppDriver(configCapabilities.GetCapabilities());
        driver.findElement(By.id("com.android.permissioncontroller:id/permission_deny_button")).click();
    }


}
