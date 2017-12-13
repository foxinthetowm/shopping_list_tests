package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * More options menu
 */
public class MoreMenu extends AbstractPage {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Settings']")
    private MobileElement settings;

    public MoreMenu(AndroidDriver driver) {
        super(driver);
    }

    public MobileElement getSettings() {
        return settings;
    }
}
