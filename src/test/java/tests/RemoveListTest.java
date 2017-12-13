package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import steps.CommonSteps;
import steps.MainPageSteps;

public class RemoveListTest extends AbstractShoppingListTest {

    private final String listName = "New list2";

    private MainPageSteps mainPageSteps;

    private CommonSteps commonSteps;

    @BeforeTest
    public void setUp() {
        mainPageSteps = new MainPageSteps(driver);
        commonSteps = new CommonSteps(driver);
    }

    @Test(description = "TC4: Remove shopping list")
    public void removeNewList() {
        mainPageSteps.checkPageDisplayed();
        mainPageSteps.setTextIntoNewListField(listName).clickAddButton();
        commonSteps.pressBackTwice();
        mainPageSteps.listWithNameExists(listName);
        mainPageSteps.deleteListWithName(listName).confirmDeletingList();
        mainPageSteps
                .listWithNameDoesNotExist(listName);
    }
}
