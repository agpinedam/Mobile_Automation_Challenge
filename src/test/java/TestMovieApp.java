import core.ConfigCapabilities;
import core.MobileAppDriver;
import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestMovieApp {

    @Test
    public void prueba() throws InterruptedException {
        ConfigCapabilities configCapabilities = new ConfigCapabilities();
        MobileAppDriver mobileAppDriver = new MobileAppDriver();
        AndroidDriver driver = mobileAppDriver.GetMoviesAppDriver(configCapabilities.GetCapabilities());
        WebDriverWait wait =new WebDriverWait(driver,60);
        By denyButton = By.id("com.android.permissioncontroller:id/permission_deny_button");
        By buttonOk= By.id("android:id/button2");
        By notNow = By.id("com.imdb.mobile:id/splash_not_now");
        By searchBar = By.id("com.imdb.mobile:id/search_src_text");
        By x = By.id("com.imdb.mobile:id/exit");
        By firstMovie = By.xpath("//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]");
        By overview = By.id("com.imdb.mobile:id/plot_overview");
        wait.until(ExpectedConditions.elementToBeClickable(denyButton));
        driver.findElement(denyButton).click();
        wait.until(ExpectedConditions.elementToBeClickable(buttonOk));
        driver.findElement(buttonOk).click();
        //wait.until(ExpectedConditions.elementToBeClickable(notNow));
        //driver.findElement(notNow).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("com.imdb.mobile:id/navigation_search_browse")));
        driver.findElement(By.id("com.imdb.mobile:id/navigation_search_browse")).click();
        //Thread.sleep(200);
        wait.until(ExpectedConditions.elementToBeClickable(x));
        driver.findElement(x).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("com.imdb.mobile:id/navigation_search_browse")));
        driver.findElement(By.id("com.imdb.mobile:id/navigation_search_browse")).click();
        wait.until(ExpectedConditions.elementToBeClickable(searchBar));
        AndroidElement search = (AndroidElement) driver.findElement(searchBar);
        search.sendKeys("Fight Club");
        wait.until(ExpectedConditions.elementToBeClickable(firstMovie));
        driver.findElement(firstMovie).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(overview));
        Assert.assertEquals(driver.findElement(overview).getText(),
                "An insomniac office worker and a devil-may-care soap maker " +
                        "form an underground fight club that evolves into much more.");
    }


}
