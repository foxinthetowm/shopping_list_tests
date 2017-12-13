package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import steps.CommonSteps;
import steps.ShoppingListPageSteps;
import steps.MoreMenuSteps;
import steps.SettingsPageSteps;

public class ChangeOrientationTest extends AbstractShoppingListTest {

    private ShoppingListPageSteps shoppingListPageSteps;

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
        shoppingListPageSteps = new ShoppingListPageSteps(driver);
        moreMenuSteps = new MoreMenuSteps(driver);
        settingsPageSteps = new SettingsPageSteps(driver);
        commonSteps = new CommonSteps(driver);
    }

    @Test(description = "[TC8] Change orientation in Settings menu ",
            dataProvider = "Orientations")
    public void checkOrientationSettings(String orientation, String
            expectedOrientation) {
        shoppingListPageSteps
                .checkPageDisplayed()
                .clickMore();
        moreMenuSteps.checkPageDisplayed().clickSettings();
        settingsPageSteps.checkPageDisplayed().clickOrientation()
                .selectOrientation(orientation);
        commonSteps.pressBack();
        shoppingListPageSteps.checkPageDisplayed();
        commonSteps.getOrientation(expectedOrientation);
    }

    @AfterMethod
    public void restartApp() {
        driver.resetApp();
    }
}

