package steps;

import io.appium.java_client.android.AndroidDriver;

/**
 *  A base for all classes with steps.
 */
public abstract class AbstractCommonStep {

    protected final AndroidDriver driver;

    protected AbstractCommonStep(AndroidDriver driver) {
        this.driver = driver;
    }
}
