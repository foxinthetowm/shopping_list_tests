package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import steps.CommonSteps;
import steps.MainPageSteps;

public class ClickNoInRemoveListWindowTest extends AbstractShoppingListTest {

    private final String listName = "New list2";

    private MainPageSteps mainPageSteps;

    private CommonSteps commonSteps;

    @BeforeTest
    public void setUp() {
        mainPageSteps = new MainPageSteps(driver);
        commonSteps = new CommonSteps(driver);
    }

    @Test(description = "TC6: Cancel shopping list deleting")
    public void clickNoInRemoveListWindow() {
        mainPageSteps.checkPageDisplayed().setTextIntoNewListField(listName)
                .clickAddButton();
        commonSteps.pressBackTwice();
        mainPageSteps.listWithNameExists(listName)
                .deleteListWithName(listName).cancelDeletingList()
                .listWithNameExists(listName);
    }
}
