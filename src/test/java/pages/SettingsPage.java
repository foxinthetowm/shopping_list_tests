package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 *  Settings page
 */
public class SettingsPage extends AbstractPage {

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

    public MobileElement getCurrency() {
        return currency;
    }

    public MobileElement getOrientation() {
        return orientation;
    }

    public MobileElement getSortBy() {
        return sortBy;
    }

    public MobileElement getCurrentCurrency() {
        return currentCurrency;
    }
}
