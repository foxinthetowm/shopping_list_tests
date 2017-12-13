package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * Elements which are present on several app screens.
 */
public class CommonElements extends AbstractPage {

    private String itemInDropDownWithName = "//android.widget" +
            ".CheckedTextView[@text='%s']";

    @AndroidFindBy(id = "com.slava.buylist:id/button1")
    private MobileElement moreButton;

    public CommonElements(AndroidDriver driver) {
        super(driver);
    }

    public String getItemInDropDownWithName() {
        return itemInDropDownWithName;
    }

    public MobileElement getMoreButton() {
        return moreButton;
    }
}
