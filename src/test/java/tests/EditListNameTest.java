package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import steps.CommonSteps;
import steps.DialogWindowSteps;
import steps.MainPageSteps;

public class EditListNameTest extends AbstractShoppingListTest {

    private final String oldName = "New list";

    private final String newName = "New list2";

    private MainPageSteps mainPageSteps;

    private DialogWindowSteps editListWindowStep;

    private CommonSteps commonSteps;

    @BeforeTest
    public void setUp() {
        mainPageSteps = new MainPageSteps(driver);
        editListWindowStep = new DialogWindowSteps(driver);
        commonSteps = new CommonSteps(driver);
    }

    @Test(description = "[TC3] Edit list: edit name")
    public void editListName() {
        mainPageSteps.checkPageDisplayed();
        mainPageSteps.setTextIntoNewListField(oldName).clickAddButton();
        commonSteps.pressBackTwice();
        mainPageSteps.listWithNameExists(oldName);
        mainPageSteps.clickEditButtonListWithName(oldName);
        editListWindowStep.setTextToTheNameField(newName).clickOk();
        mainPageSteps
                .listWithNameExists(newName);
    }
}
