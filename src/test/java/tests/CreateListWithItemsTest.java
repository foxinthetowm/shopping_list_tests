package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AddProductsPage;
import pages.MainPage;

public class CreateListWithItemsTest extends AndroidSetup {

    private MainPage mainPage;

    private AddProductsPage productsPage;

    private SoftAssert softAssertion = new SoftAssert();

    @DataProvider(name = "Products parameters")
    public static Object[][] listNames() {
        return new Object[][]{ { "New list", "product1", "3", "2", "comment",
                "kg.", "Pet products", "6" }, { "New list1",
                "product11", "1", "0", "comment",
                "kg.", "Pet products", "0" } };
    }

    @BeforeTest
    private void setUp() {
        mainPage = new MainPage(AndroidSetup.driver);
        productsPage = new AddProductsPage(driver);
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
        mainPage = new MainPage(driver);
        mainPage
                .headerDisplayed()
                .setTextIntoNewListField(listName)
                .clickAddButton();
        productsPage = new AddProductsPage(driver);
        productsPage.addProductScreenDisplayed();
        productsPage.addNewProduct(productName, price, amount, testComment,
                measure, category);
        softAssertion.assertTrue(productsPage.productWithNameExists
                (productName));
        softAssertion.assertTrue(productsPage.checkQuantityOfProductWithName
                (productName, amount
                        + " " + measure));
        softAssertion.assertTrue(productsPage.checkPriceOfProductWithName
                (productName, price));
        softAssertion.assertTrue(productsPage.checkCommentForProductWithName
                (productName,
                        testComment));
        softAssertion.assertTrue(productsPage.checkTotal(total));
        softAssertion.assertAll();
        mainPage.pressBackTwice();
        softAssertion.assertTrue(mainPage.listWithNameExists(listName));
        softAssertion.assertAll();
    }

    @AfterMethod
    public void restartApp( ) {
        driver.resetApp();
    }
}
