package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public abstract class AbstractShoppingListTest {

    protected static AndroidDriver<AndroidElement> driver;

    @BeforeSuite
    public void setUpAppium( ) throws MalformedURLException {
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        File appDir = new File("src/test/resources/");
        File app = new File(appDir, "Shopping_list_1.6.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,
                getDeviceName(System.getProperty("api")));
        capabilities.setCapability(MobileCapabilityType.APP, app
                .getAbsolutePath());
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
                capabilities);
        driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
    }

    @AfterSuite
    public void tearDownAppium( ) {
        driver.quit();
    }

    @AfterClass
    public void restartApp( ) {
        driver.resetApp();
    }

    private String getDeviceName(String api) {
        Map<String, String> devices = new HashMap<>();
        devices.put("26", "Pixel_API_26");
        devices.put("25", "Pixel_API_25");
        devices.put("24", "Nexus 5X API 24");
        devices.put("23", "Nexus 5 API 23");
        return devices.get(api);
    }
}
