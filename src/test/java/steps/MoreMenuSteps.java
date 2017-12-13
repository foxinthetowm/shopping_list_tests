package steps;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import pages.MoreMenu;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 *  Steps for More menu view
 */
public class MoreMenuSteps extends AbstractStep {

    private MoreMenu moreMenu = new MoreMenu(driver);

    public MoreMenuSteps(AndroidDriver driver) {
        super(driver);
    }

    @Override
    public MoreMenuSteps checkPageDisplayed( ) {
        assertThat("More menu is not displayed", moreMenu.getSettings()
                .isDisplayed());
        return this;
    }

    @Step("Click 'Settings'")
    public MoreMenuSteps clickSettings( ) {
        moreMenu.getSettings().click();
        return this;
    }
}
