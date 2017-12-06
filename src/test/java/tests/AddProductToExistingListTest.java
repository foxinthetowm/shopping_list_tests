package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AddProductsPage;
import pages.MainPage;

public class AddProductToExistingListTest extends AbstractShoppingListTest {

    private MainPage mainPage;

    private AddProductsPage productsPage;

    private SoftAssert softAssertion = new SoftAssert();

    @DataProvider(name = "Products parameters")
    public static Object[][] listNames( ) {
        return new Object[][]{ { "New list", "product1", "3", "2", "comment",
                "kg.", "Pet products", "product2", "4", "1",
                "comment", "kg.", "Ornamentation", "10" }, { "New list2",
                "product11", "1", "0", "comment",
                "kg.", "Pet products", "product22", "4", "1",
                "comment", "kg.", "Ornamentation", "4" } };
    }

    @BeforeTest
    private void setUp( ) {
        mainPage = new MainPage(AbstractShoppingListTest.driver);
        productsPage = new AddProductsPage(driver);
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
        mainPage
                .headerDisplayed()
                .setTextIntoNewListField(listName)
                .clickAddButton();
        productsPage.addProductScreenDisplayed();
        productsPage.
                addNewProduct(productName1, price1, amount1, testComment1,
                        measure1, category1)
                .pressBackTwice();
        mainPage.listWithNameExists(listName);
        mainPage.openListWithName(listName);
        productsPage.addProductScreenDisplayed();
        productsPage.addNewProduct(productName2, price2, amount2, testComment2,
                measure2, category2);
        softAssertion.assertTrue(productsPage.productWithNameExists
                (productName1));
        softAssertion.assertTrue(productsPage.productWithNameExists
                (productName2));
        softAssertion.assertTrue(productsPage.checkQuantityOfProductWithName
                (productName2, amount2
                        + " " + measure2));
        softAssertion.assertTrue(productsPage.checkQuantityOfProductWithName
                (productName1, amount1
                        + " " + measure1));
        softAssertion.assertTrue(productsPage.checkPriceOfProductWithName
                (productName1, price1));
        softAssertion.assertTrue(productsPage.checkPriceOfProductWithName
                (productName2, price2));
        softAssertion.assertTrue(productsPage.checkCommentForProductWithName
                (productName1,
                        testComment1));
        softAssertion.assertTrue(productsPage.checkCommentForProductWithName
                (productName2,
                        testComment2));
        softAssertion.assertTrue(productsPage.checkTotal(total));
        softAssertion.assertAll();
    }

    @AfterMethod
    public void restartApp( ) {
        driver.resetApp();
    }
}
