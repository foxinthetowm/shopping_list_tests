package steps;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import pages.CommonElements;
import pages.SettingsPage;

import static java.lang.String.format;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 *  Steps for Settings page
 */
public class SettingsPageSteps extends AbstractStep {

    private SettingsPage settingsPage = new SettingsPage(driver);

    private CommonElements commonElements = new CommonElements(driver);

    public SettingsPageSteps(AndroidDriver driver) {
        super(driver);
    }

    @Override
    public SettingsPageSteps checkPageDisplayed() {
        assertThat("Settings menu is not displayed", settingsPage.getCurrency()
                .isDisplayed());
        return this;
    }

    @Step("Click 'Currency' setting")
    public SettingsPageSteps clickCurrency() {
        settingsPage.getCurrency().click();
        return this;
    }

    @Step("Check current currency value")
    public SettingsPageSteps checkCurrentCurrency(String expectedCurrency) {
        String actualCurrency = settingsPage
                .getCurrentCurrency()
                .getText();
        assertThat(String.format("Currency value is incorrect: expected " +
                        "currency is %s, " +
                        "but actual is %s", expectedCurrency, actualCurrency),
                actualCurrency.equals
                        (expectedCurrency));
        return this;
    }

    @Step("Select currency")
    public SettingsPageSteps selectCurrency(String currency) {
        driver.findElementByXPath(format(commonElements
                .getItemInDropDownWithName(), currency))
                .click();
        return this;
    }

    @Step("Click 'Orientation' setting")
    public SettingsPageSteps clickOrientation() {
        settingsPage.getOrientation().click();
        return this;
    }

    @Step("Click 'Sort By' setting")
    public SettingsPageSteps clickSortBy() {
        settingsPage.getSortBy().click();
        return this;
    }

    @Step("Select orientation")
    public SettingsPageSteps selectOrientation(String orientation) {
        driver.findElementByXPath(format(commonElements
                .getItemInDropDownWithName(), orientation))
                .click();
        return this;
    }

    @Step("Select sort by")
    public SettingsPageSteps selectSortBy(String sortBy) {
        driver.findElementByXPath(format(commonElements
                .getItemInDropDownWithName(), sortBy))
                .click();
        return this;
    }
}
