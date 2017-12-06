package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.MoreMenu;
import pages.SettingsPage;

import static org.hamcrest.MatcherAssert.assertThat;

public class CurrencySettingsTest extends AbstractShoppingListTest {

    private MainPage mainPage;

    private MoreMenu moreMenu;

    private SettingsPage settingsPage;

    @BeforeTest
    void setUp( ) {
        mainPage = new MainPage(driver);
        moreMenu = new MoreMenu(driver);
        settingsPage = new SettingsPage(driver);
    }

    @Test(description = "[TC8] Change currency in Settings menu")
    public void checkCurrencySettings( ) {
        mainPage
                .headerDisplayed()
                .clickMore();
        moreMenu.clickSettings();
        settingsPage.clickCurrency().selectCurrency("$");
        assertThat("Currency was not changed", settingsPage
                .checkCurrentCurrency("$"));
    }
}
