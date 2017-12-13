package steps;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;

/**
 *  Class provides common actions for the Shopping List app pages
 */
public abstract class AbstractStep extends AbstractCommonStep {

    protected AbstractStep(AndroidDriver driver) {
        super(driver);
    }

    @Step("Check the page is displayed")
    public abstract AbstractStep checkPageDisplayed();
}
