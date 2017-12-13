package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import steps.CommonSteps;
import steps.ShoppingListPageSteps;

public class ClickNoInRemoveListWindowTest extends AbstractShoppingListTest {

    private final String listName = "New list2";

    private ShoppingListPageSteps shoppingListPageSteps;

    private CommonSteps commonSteps;

    @BeforeTest
    public void setUp() {
        shoppingListPageSteps = new ShoppingListPageSteps(driver);
        commonSteps = new CommonSteps(driver);
    }

    @Test(description = "TC6: Cancel shopping list deleting")
    public void clickNoInRemoveListWindow() {
        shoppingListPageSteps.checkPageDisplayed().setTextIntoNewListField(listName)
                .clickAddButton();
        commonSteps.pressBackTwice();
        shoppingListPageSteps.listWithNameExists(listName)
                .deleteListWithName(listName).cancelDeletingList()
                .listWithNameExists(listName);
    }
}
