package steps;

import io.appium.java_client.android.AndroidDriver;

public abstract class AbstractCommonStep {

    protected final AndroidDriver driver;

    protected AbstractCommonStep(AndroidDriver driver) {
        this.driver = driver;
    }
}
