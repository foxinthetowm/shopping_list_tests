package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;

public class SettingsPage extends Page {

    CommonElements commonElements = new CommonElements(driver);

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Currency']")
    MobileElement currency;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Orientation']")
    MobileElement orientation;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sort list']")
    MobileElement sortBy;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@index='2']/android" +
            ".widget.RelativeLayout/android.widget" +
            ".TextView[@resource-id='android:id/summary']")
    MobileElement currentCurrency;

    public SettingsPage(AndroidDriver driver) {
        super(driver);
    }

    @Step("Click 'Currency' setting")
    public SettingsPage clickCurrency() {
        currency.click();
        return this;
    }

    @Step("Check current currency value")
    public boolean checkCurrentCurrency(String expectedCurrency) {
        return currentCurrency.getText().equals(expectedCurrency);
    }

    @Step("Select currency")
    public SettingsPage selectCurrency(String currency) {
        commonElements.selectItemWithName(currency);
        return this;
    }

    @Step("Click 'Orientation' setting")
    public SettingsPage clickOrientation() {
        orientation.click();
        return this;
    }

    @Step("Click 'Sort By' setting")
    public SettingsPage clickSortBy() {
        sortBy.click();
        return this;
    }

    @Step("Select orientation")
    public SettingsPage selectOrientation(String orientation) {
        commonElements.selectItemWithName(orientation);
        return this;
    }

    @Step("Select sort by")
    public SettingsPage selectSortBy(String sortBy) {
        commonElements.selectItemWithName(sortBy);
        return this;
    }
}
