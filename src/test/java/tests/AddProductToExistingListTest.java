package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import steps.AddProductPageSteps;
import steps.CommonSteps;
import steps.ShoppingListPageSteps;

public class AddProductToExistingListTest extends AbstractShoppingListTest {

    private ShoppingListPageSteps shoppingListPageSteps;

    private AddProductPageSteps addProductPageSteps;

    private CommonSteps commonSteps;

    @DataProvider(name = "Products parameters")
    public static Object[][] listNames() {
        return new Object[][]{{"New list", "product1", "3", "2", "comment",
                "kg.", "Pet products", "product2", "4", "1",
                "comment", "kg.", "Ornamentation", "10"}, {"New list2",
                "product11", "1", "0", "comment",
                "kg.", "Pet products", "product22", "4", "1",
                "comment", "kg.", "Ornamentation", "4"}};
    }

    @BeforeTest
    private void setUp() {
        shoppingListPageSteps = new ShoppingListPageSteps(AbstractShoppingListTest.driver);
        addProductPageSteps = new AddProductPageSteps(driver);
        commonSteps = new CommonSteps(driver);
    }

    @Test(description = "[TC7] Edit list: add a product", dataProvider =
            "Products parameters")
    public void addNewItemToTheList(String listName,
                                    String productName1,
                                    String price1,
                                    String amount1,
                                    String testComment1,
                                    String measure1,
                                    String category1,
                                    String productName2,
                                    String price2,
                                    String amount2,
                                    String testComment2,
                                    String measure2,
                                    String category2,
                                    String total) {
        shoppingListPageSteps
                .checkPageDisplayed()
                .setTextIntoNewListField(listName)
                .clickAddButton();
        addProductPageSteps.checkPageDisplayed().addNewProduct
                (productName1, price1, amount1, testComment1,
                        measure1, category1);
        commonSteps.pressBackTwice();
        shoppingListPageSteps.listWithNameExists(listName).openListWithName(listName);
        addProductPageSteps.checkPageDisplayed()
                .addNewProduct(productName2, price2, amount2, testComment2,
                        measure2, category2)
                .checkProductParameters(productName1, amount1, measure1, price1,
                        testComment1)
                .checkProductParameters(productName2, amount2,
                        measure2, price2,
                        testComment2)
                .checkTotal(total);
    }

    @AfterMethod
    public void restartApp() {
        driver.resetApp();
    }
}
