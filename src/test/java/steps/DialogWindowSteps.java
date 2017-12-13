package steps;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import pages.DialogWindow;

public class DialogWindowSteps extends AbstractCommonStep {

    private DialogWindow dialogWindow = new DialogWindow(driver);

    public DialogWindowSteps(AndroidDriver driver) {
        super(driver);
    }

    @Step("Set a new name for specified list")
    public DialogWindowSteps setTextToTheNameField(String nameList) {
        dialogWindow.getListName().isDisplayed();
        dialogWindow.getListName().clear();
        dialogWindow.getListName().sendKeys(nameList);
        return this;
    }

    @Step("Click ok button in the dialog window")
    public DialogWindowSteps clickOk() {
        dialogWindow.getOkButton().click();
        return this;
    }

    @Step("Click no button in the dialog window")
    public DialogWindowSteps clickNo() {
        dialogWindow.getNoButton().click();
        return this;
    }
}
