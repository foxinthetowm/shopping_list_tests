package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import steps.CommonSteps;
import steps.ShoppingListPageSteps;

public class RemoveListTest extends AbstractShoppingListTest {

    private final String listName = "New list2";

    private ShoppingListPageSteps shoppingListPageSteps;

    private CommonSteps commonSteps;

    @BeforeTest
    public void setUp() {
        shoppingListPageSteps = new ShoppingListPageSteps(driver);
        commonSteps = new CommonSteps(driver);
    }

    @Test(description = "TC4: Remove shopping list")
    public void removeNewList() {
        shoppingListPageSteps.checkPageDisplayed();
        shoppingListPageSteps.setTextIntoNewListField(listName).clickAddButton();
        commonSteps.pressBackTwice();
        shoppingListPageSteps.listWithNameExists(listName);
        shoppingListPageSteps.deleteListWithName(listName).confirmDeletingList();
        shoppingListPageSteps
                .listWithNameDoesNotExist(listName);
    }
}
