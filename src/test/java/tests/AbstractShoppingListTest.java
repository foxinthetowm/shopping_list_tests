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

public abstract class AbstractShoppingListTest {

    private static final String DEFAULT_DEVICE = "Pixel_API_26";

    /**
     * Dictionary is a {@link Map} collection that contains {@link String}
     * Android API level as a key and {@link String} device name as a value.
     */
    private static final Map<String, String> DEVICES = new HashMap<String,
            String>
            () {{
        put("26", "Pixel_API_26");
        put("25", "Pixel_API_25");
        put("24", "Nexus 5X API 24");
        put("23", "Nexus 5 API 23");
    }};

    protected static AndroidDriver<AndroidElement> driver;

    @BeforeSuite
    public void setUpAppium() throws MalformedURLException {
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        File appDir = new File("src/test/resources/");
        File app = new File(appDir, "Shopping_list_1.6.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,
                getDeviceName(System.getProperty("api_version")));
        capabilities.setCapability(MobileCapabilityType.APP, app
                .getAbsolutePath());
        driver = new AndroidDriver(url,
                capabilities);
    }

    private String getDeviceName(String api) {
        return (api == null) ? DEFAULT_DEVICE : DEVICES.get(api);
    }

    @AfterSuite
    public void tearDownAppium() {
        driver.quit();
    }

    @AfterClass
    public void restartApp() {
        driver.resetApp();
    }
}
