package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import steps.MainPageSteps;
import steps.MoreMenuSteps;
import steps.SettingsPageSteps;

public class CurrencySettingsTest extends AbstractShoppingListTest {

    private MainPageSteps mainPageSteps;

    private MoreMenuSteps moreMenuSteps;

    private SettingsPageSteps settingsPageSteps;

    @BeforeTest
    void setUp() {
        mainPageSteps = new MainPageSteps(driver);
        moreMenuSteps = new MoreMenuSteps(driver);
        settingsPageSteps = new SettingsPageSteps(driver);
    }

    @Test(description = "[TC8] Change currency in Settings menu")
    public void checkCurrencySettings() {
        mainPageSteps
                .checkPageDisplayed()
                .clickMore();
        moreMenuSteps.checkPageDisplayed().clickSettings();
        settingsPageSteps.checkPageDisplayed().clickCurrency()
                .selectCurrency("$");
        settingsPageSteps
                .checkCurrentCurrency("$");
    }
}
