package steps;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.qameta.allure.Step;

import static org.hamcrest.MatcherAssert.assertThat;

public class CommonSteps extends AbstractCommonStep {

    public CommonSteps(AndroidDriver driver) {
        super(driver);
    }

    @Step("Press system Back button twice")
    public CommonSteps pressBackTwice( ) {
        driver.sendKeyEvent(AndroidKeyCode.BACK);
        driver.sendKeyEvent(AndroidKeyCode.BACK);
        return this;
    }

    @Step("Press system Back button")
    public CommonSteps pressBack( ) {
        driver.sendKeyEvent(AndroidKeyCode.BACK);
        return this;
    }

    @Step("Check orientation")
    public CommonSteps getOrientation(String expectedOrientation) {
        String actualOrientation = driver
                .getOrientation().toString();
        assertThat(String.format("Expected orientation is %s, but actiual is " +
                        "%s", expectedOrientation, actualOrientation),
                actualOrientation.equals
                        (expectedOrientation));
        return this;
    }
}
