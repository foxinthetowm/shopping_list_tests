package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import steps.ShoppingListPageSteps;

public class AddListWithEmptyNameWithShortName extends
        AbstractShoppingListTest {

    private ShoppingListPageSteps shoppingListPageSteps;

    @DataProvider(name = "Invalid list names")
    public static Object[][] listNames() {
        return new Object[][]{{""}, {"11"}, {"aa"}, {"!@"}, {"  "
        }, {"__"}};
    }

    @BeforeTest
    public void setUp() {
        shoppingListPageSteps = new ShoppingListPageSteps(AbstractShoppingListTest.driver);
    }

    @Test(description = "[TC5] Check user cannot add a list with name shorter" +
            " " +
            "that 3 symbols", dataProvider = "Invalid list names")
    public void addNewListWithShortName(String listName) {
        shoppingListPageSteps
                .checkPageDisplayed()
                .setTextIntoNewListField(listName)
                .clickAddButton().listDoesNotExist();
    }

    @AfterMethod
    public void restartApp() {
        driver.resetApp();
    }
}
