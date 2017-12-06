package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.MoreMenu;
import pages.SettingsPage;

import static org.hamcrest.MatcherAssert.assertThat;

public class ChangeOrientationTest extends AbstractShoppingListTest {

    private MainPage mainPage;

    private MoreMenu moreMenu;

    private SettingsPage settingsPage;

    @DataProvider(name = "Orientations")
    public static Object[][] listNames() {
        return new Object[][]{ { "Horizontal", "LANDSCAPE" }, { "Vertical",
                "PORTRAIT" },
                { "Auto", "PORTRAIT" }
        };
    }

    @BeforeTest
    void setUp() {
        mainPage = new MainPage(driver);
        moreMenu = new MoreMenu(driver);
        settingsPage = new SettingsPage(driver);
    }

    @Test(description = "[TC8] Change orientation in Settings menu ",
            dataProvider = "Orientations")
    public void checkOrientationSettings(String orientation, String
            expectedOrientation) {
        mainPage
                .headerDisplayed()
                .clickMore();
        moreMenu.clickSettings();
        settingsPage.clickOrientation().selectOrientation(orientation)
                .pressBack();
        mainPage.headerDisplayed();
        assertThat("Orientation was not changed", mainPage.getOrientation()
                .equals(expectedOrientation));
    }

    @AfterMethod
    public void restartApp( ) {
        driver.resetApp();
    }
}

