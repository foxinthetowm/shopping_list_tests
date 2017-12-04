package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

import static java.lang.String.format;

public class CommonElements extends Page {

    private String itemInDropDownWithName = "//android.widget" +
            ".CheckedTextView[@text='%s']";


    @AndroidFindBy(id = "com.slava.buylist:id/button1")
    private MobileElement moreButton;

    protected CommonElements(AndroidDriver driver) {
        super(driver);
    }

    protected void selectItemWithName(String itemName) {
        driver.findElementByXPath(format(itemInDropDownWithName, itemName))
                .click();
    }

    protected void clickMore( ) {
        moreButton.click();
    }
}
