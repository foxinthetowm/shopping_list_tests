package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import steps.CommonSteps;
import steps.ShoppingListPageSteps;

public class AddEmptyListTest extends AbstractShoppingListTest {

    private ShoppingListPageSteps shoppingListPageSteps;

    private CommonSteps commonSteps;

    @DataProvider(name = "Valid list names")
    public static Object[][] listNames() {
        return new Object[][]{{"list"}, {"List name"}, {"aaa"}, {
                "!@!"}, {"   "}, {"Is it 30 symbols string? Yep!!"}};
    }

    @BeforeTest
    public void setUp() {
        shoppingListPageSteps = new ShoppingListPageSteps(driver);
        commonSteps = new CommonSteps(driver);
    }

    @Test(description = "[TC1] Add an empty shopping list", dataProvider =
            "Valid list names")
    public void addEmptyList(String listName) {
        shoppingListPageSteps
                .checkPageDisplayed()
                .setTextIntoNewListField(listName)
                .clickAddButton();
        commonSteps.pressBackTwice();
        shoppingListPageSteps.listWithNameExists(listName);
    }

    @AfterMethod
    public void restartApp() {
        driver.resetApp();
    }
}
