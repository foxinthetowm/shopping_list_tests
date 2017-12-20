package steps;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Steps for common elements
 */
public class CommonSteps extends AbstractCommonStep {

    private WebDriverWait wait = new WebDriverWait(driver, 10);

    public CommonSteps(AndroidDriver driver) {
        super(driver);
    }

    @Step("Press system Back button twice")
    public CommonSteps pressBackTwice() {
        driver.sendKeyEvent(AndroidKeyCode.BACK);
        driver.sendKeyEvent(AndroidKeyCode.BACK);
        return this;
    }

    @Step("Press system Back button")
    public CommonSteps pressBack() {
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

    @Step("Wait until an element is displayed")
    public CommonSteps waitUntilDisplayed(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return this;
    }
}
