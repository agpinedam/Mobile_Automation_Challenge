package screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginScreen extends BaseScreen{
    private final By signInWithGoogle = By.id("com.imdb.mobile:id/google_oauth");
    private final Logger log = LoggerFactory.getLogger(LoginScreen.class);

    public LoginScreen(AndroidDriver driver) {
        super(driver);
    }

    public void loginWithGoogle(){
        clickOnElement(signInWithGoogle);
        log.debug("Click on Sing in with Google account");
    }

}
