package steps;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import pages.DialogWindow;

/**
 * Steps for edit list name dialog window,
 */
public class DialogWindowSteps extends AbstractCommonStep {

    private DialogWindow dialogWindow = new DialogWindow(driver);

    private CommonSteps commonSteps = new CommonSteps(driver);

    public DialogWindowSteps(AndroidDriver driver) {
        super(driver);
    }

    @Step("Set a new name for specified list")
    public DialogWindowSteps setTextToTheNameField(String nameList) {
        commonSteps.waitUntilDisplayed(dialogWindow.getListName());
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
