package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class DialogWindow extends AbstractPage {

    @AndroidFindBy(className = "android.widget.EditText")
    private MobileElement listName;

    @AndroidFindBy(id = "android:id/button1")
    private MobileElement okButton;

    @AndroidFindBy(id = "android:id/button2")
    private MobileElement noButton;

    public DialogWindow(AndroidDriver driver) {
        super(driver);
    }

    public MobileElement getListName() {
        return listName;
    }

    public MobileElement getOkButton() {
        return okButton;
    }

    public MobileElement getNoButton() {
        return noButton;
    }
}
