package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import steps.CommonSteps;
import steps.ShoppingListPageSteps;

public class ClickNoInRemoveListWindowTest extends AbstractShoppingListTest {

    private ShoppingListPageSteps shoppingListPageSteps;

    private CommonSteps commonSteps;

    @BeforeTest
    public void setUp() {
        shoppingListPageSteps = new ShoppingListPageSteps(driver);
        commonSteps = new CommonSteps(driver);
    }

    @Test(description = "TC6: Cancel shopping list deleting")
    public void clickNoInRemoveListWindow() {
        String list_name = "New list2";
        shoppingListPageSteps.checkPageDisplayed().setTextIntoNewListField
                (list_name)
                .clickAddButton();
        commonSteps.pressBackTwice();
        shoppingListPageSteps.listWithNameExists(list_name)
                .deleteListWithName(list_name).cancelDeletingList()
                .listWithNameExists(list_name);
    }
}
