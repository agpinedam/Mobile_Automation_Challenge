package core;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.io.FileNotFoundException;
import java.io.FileReader;

public class ConfigCapabilities {
    private static final String DEVICE_NAME = "deviceName";
    private static final String PLATFORM_NAME = "platformName";
    private static final String APP_PACKAGE = "appPackage";
    private static final String APP_ACTIVITY = "appActivity";
    private static final String JSON_FILE_PATH = "src/test/resources/Capabilities.json";
    private static final JsonParser parser = new JsonParser();
    private static final DesiredCapabilities capabilities = new DesiredCapabilities();

    private static void ApplicationSetUp(){
        ConfigCapabilities.capabilities.setCapability("appPackage", getJsonDataProperty(APP_PACKAGE));
        ConfigCapabilities.capabilities.setCapability("appActivity", getJsonDataProperty(APP_ACTIVITY));
        ConfigCapabilities.capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, getJsonDataProperty(DEVICE_NAME));
        ConfigCapabilities.capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, getJsonDataProperty(PLATFORM_NAME));
        ConfigCapabilities.capabilities.setCapability("automationName", "UiAutomator2");
    }

    private static String getJsonDataProperty(String property) {
        try {
            Object obj = parser.parse(new FileReader(JSON_FILE_PATH));
            JsonObject jsonObject = (JsonObject) obj;
            return jsonObject.get(property).getAsString();
        } catch (FileNotFoundException e) {
            //log.error("e.getMessage()");
        } catch (Exception e) {
            //log.error(e.getMessage(), e);
        }
        return "";
    }

    public DesiredCapabilities GetCapabilities(){
        ConfigCapabilities.ApplicationSetUp();
        return capabilities;
    }
}