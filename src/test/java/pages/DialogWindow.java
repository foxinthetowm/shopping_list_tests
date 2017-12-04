package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;

public class DialogWindow extends Page {

    @AndroidFindBy(className = "android.widget.EditText")
    private MobileElement listName;

    @AndroidFindBy(id = "android:id/button1")
    private MobileElement okButton;

    @AndroidFindBy(id = "android:id/button2")
    private MobileElement noButton;

    public DialogWindow(AndroidDriver driver) {
        super(driver);
    }

    @Step("Set a new name for specified list")
    public DialogWindow setTextToTheNameField(String nameList) {
        listName.isDisplayed();
        listName.clear();
        listName.sendKeys(nameList);
        return this;
    }

    @Step("Click ok button in the dialog window")
    public DialogWindow clickOk() {
        okButton.click();
        return this;
    }

    @Step("Click no button in the dialog window")
    public DialogWindow clickNo() {
        noButton.click();
        return this;
    }
}
