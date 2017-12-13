package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import steps.*;

public class SortProductsByTest extends AbstractShoppingListTest {

    private ShoppingListPageSteps shoppingListPageSteps;

    private AddProductPageSteps addProductPageSteps;

    private MoreMenuSteps moreMenuSteps;

    private SettingsPageSteps settingsPageSteps;

    private CommonSteps commonSteps;

    @DataProvider(name = "Products parameters")
    public static Object[][] listNames() {
        return new Object[][]{{"New list", "aaa", "3", "2", "comment",
                "kg.", "Pet products", "bbb", "4", "1",
                "comment", "kg.", "Medications", "ccc", "1", "0", "comment",
                "kg.", "Dairy produce", "By category", new String[]
                {"ccc", "aaa", "bbb"}}, {"New list2", "aaa", "3", "2",
                "comment", "kg.", "Pet products", "bbb", "4", "1",
                "comment", "kg.", "Medications", "ccc", "1", "0", "comment",
                "kg.", "Dairy produce", "By alphabet", new String[]
                {"aaa", "bbb", "ccc"}}};
    }

    @BeforeTest
    private void setUp() {
        shoppingListPageSteps = new ShoppingListPageSteps(AbstractShoppingListTest.driver);
        addProductPageSteps = new AddProductPageSteps(driver);
        moreMenuSteps = new MoreMenuSteps(driver);
        settingsPageSteps = new SettingsPageSteps(driver);
        commonSteps = new CommonSteps(driver);
    }

    @Test(description = "[TC7] Edit list: add a product", dataProvider =
            "Products parameters")
    public void checkSortingProducts(String listName,
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
                                     String category2, String productName3,
                                     String price3,
                                     String amount3,
                                     String testComment3,
                                     String measure3,
                                     String category3,
                                     String sortBy,
                                     String[] expectedSorting) {
        shoppingListPageSteps
                .checkPageDisplayed()
                .setTextIntoNewListField(listName)
                .clickAddButton();
        addProductPageSteps.checkPageDisplayed();
        addProductPageSteps.
                addNewProduct(productName1, price1, amount1, testComment1,
                        measure1, category1);
        addProductPageSteps.addNewProduct(productName2, price2, amount2,
                testComment2,
                measure2, category2);
        addProductPageSteps.addNewProduct(productName3, price3, amount3,
                testComment3,
                measure3, category3);
        addProductPageSteps.clickMore();
        moreMenuSteps.checkPageDisplayed().clickSettings();
        settingsPageSteps.checkPageDisplayed().clickSortBy().selectSortBy
                (sortBy);
        commonSteps.pressBack();
        addProductPageSteps.getOrderedProductList(expectedSorting);
    }

    @AfterMethod
    public void restartApp() {
        driver.resetApp();
    }
}
