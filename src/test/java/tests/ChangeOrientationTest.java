package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import steps.CommonSteps;
import steps.MainPageSteps;
import steps.MoreMenuSteps;
import steps.SettingsPageSteps;

public class ChangeOrientationTest extends AbstractShoppingListTest {

    private MainPageSteps mainPageSteps;

    private MoreMenuSteps moreMenuSteps;

    private SettingsPageSteps settingsPageSteps;

    private CommonSteps commonSteps;

    @DataProvider(name = "Orientations")
    public static Object[][] listNames() {
        return new Object[][]{{"Horizontal", "LANDSCAPE"}, {"Vertical",
                "PORTRAIT"},
                {"Auto", "PORTRAIT"}
        };
    }

    @BeforeTest
    void setUp() {
        mainPageSteps = new MainPageSteps(driver);
        moreMenuSteps = new MoreMenuSteps(driver);
        settingsPageSteps = new SettingsPageSteps(driver);
        commonSteps = new CommonSteps(driver);
    }

    @Test(description = "[TC8] Change orientation in Settings menu ",
            dataProvider = "Orientations")
    public void checkOrientationSettings(String orientation, String
            expectedOrientation) {
        mainPageSteps
                .checkPageDisplayed()
                .clickMore();
        moreMenuSteps.checkPageDisplayed().clickSettings();
        settingsPageSteps.checkPageDisplayed().clickOrientation()
                .selectOrientation(orientation);
        commonSteps.pressBack();
        mainPageSteps.checkPageDisplayed();
        commonSteps.getOrientation(expectedOrientation);
    }

    @AfterMethod
    public void restartApp() {
        driver.resetApp();
    }
}

