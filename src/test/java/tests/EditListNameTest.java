package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import steps.CommonSteps;
import steps.DialogWindowSteps;
import steps.ShoppingListPageSteps;

public class EditListNameTest extends AbstractShoppingListTest {

    private ShoppingListPageSteps shoppingListPageSteps;

    private DialogWindowSteps editListWindowStep;

    private CommonSteps commonSteps;

    @BeforeTest
    public void setUp() {
        shoppingListPageSteps = new ShoppingListPageSteps(driver);
        editListWindowStep = new DialogWindowSteps(driver);
        commonSteps = new CommonSteps(driver);
    }

    @Test(description = "[TC3] Edit list: edit name")
    public void editListName() {
        String oldName = "New list";
        String newName = "New list2";
        shoppingListPageSteps.checkPageDisplayed();
        shoppingListPageSteps.setTextIntoNewListField(oldName).clickAddButton();
        commonSteps.pressBackTwice();
        shoppingListPageSteps.listWithNameExists(oldName);
        shoppingListPageSteps.clickEditButtonListWithName(oldName);
        editListWindowStep.setTextToTheNameField(newName).clickOk();
        shoppingListPageSteps
                .listWithNameExists(newName);
    }
}
