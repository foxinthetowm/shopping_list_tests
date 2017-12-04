package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;

public class MoreMenu extends Page {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Settings']")
    private MobileElement settings;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='My List']")
    private MobileElement myList;

    public MoreMenu(AndroidDriver driver) {
        super(driver);
    }

    @Step("Click 'Settings'")
    public MoreMenu clickSettings() {
        settings.isDisplayed();
        settings.click();
        return this;
    }

    @Step("Click 'My List'")
    public MoreMenu clickMyList() {
        myList.isDisplayed();
        myList.click();
        return this;
    }
}
