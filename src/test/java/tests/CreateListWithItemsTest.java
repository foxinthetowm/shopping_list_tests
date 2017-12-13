package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import steps.AddProductPageSteps;
import steps.CommonSteps;
import steps.ShoppingListPageSteps;

public class CreateListWithItemsTest extends AbstractShoppingListTest {

    private ShoppingListPageSteps shoppingListPageSteps;

    private AddProductPageSteps addProductPageSteps;

    private CommonSteps commonSteps;

    @DataProvider(name = "Products parameters")
    public static Object[][] listNames( ) {
        return new Object[][]{ { "New list", "product1", "3", "2", "comment",
                "kg.", "Pet products", "6" }, { "New list1",
                "product11", "1", "0", "comment",
                "kg.", "Pet products", "0" } };
    }

    @BeforeTest
    private void setUp( ) {
        shoppingListPageSteps = new ShoppingListPageSteps(AbstractShoppingListTest.driver);
        addProductPageSteps = new AddProductPageSteps(driver);
        commonSteps = new CommonSteps(driver);
    }

    @Test(description = "[TC2] Create a list with item", dataProvider =
            "Products parameters")
    public void addNewListWithItem(String listName,
                                   String productName,
                                   String price,
                                   String amount,
                                   String testComment,
                                   String measure,
                                   String category,
                                   String total) {
        shoppingListPageSteps
                .checkPageDisplayed()
                .setTextIntoNewListField(listName)
                .clickAddButton();
        addProductPageSteps.checkPageDisplayed();
        addProductPageSteps.addNewProduct(productName, price, amount,
                testComment,
                measure, category);
        addProductPageSteps.checkProductParameters(productName,
                amount,
                measure, price,
                testComment).checkTotal(total);
        commonSteps.pressBackTwice();
        shoppingListPageSteps.listWithNameExists(listName);
    }

    @AfterMethod
    public void restartApp( ) {
        driver.resetApp();
    }
}
