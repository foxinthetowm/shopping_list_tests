package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AddProductsPage;
import pages.DialogWindow;
import pages.MainPage;

import static org.hamcrest.MatcherAssert.assertThat;

public class DoNotSaveProductTest extends AndroidSetup {

    private MainPage mainPage;

    private AddProductsPage productsPage;

    private DialogWindow dialogWindow;

    @DataProvider(name = "Products parameters")
    public static Object[][] listNames( ) {
        return new Object[][]{ { "New list", "product1", "2", "5", "comment",
                "kg.", "Pet products" } };
    }

    @BeforeTest
    private void setUp( ) {
        mainPage = new MainPage(AndroidSetup.driver);
        productsPage = new AddProductsPage(driver);
        dialogWindow = new DialogWindow(driver);
    }

    @Test(description = "[TC8] Create a list but do not save a new product")
    public void doNotSaveNewProduct(String listName,
                                    String productName,
                                    String price,
                                    String amount,
                                    String testComment,
                                    String measure,
                                    String category) {
        mainPage
                .headerDisplayed()
                .setTextIntoNewListField(listName)
                .clickAddButton();
        productsPage.addProductScreenDisplayed();
        productsPage.setTextToProductNameField(productName)
                .setTextToProductPriceField(price)
                .setTextToProductAmountField(amount)
                .setTextToProductCommentField(testComment)
                .selectMeasure(measure)
                .selectCategory(category).pressBackTwice();
        dialogWindow.clickNo();
        mainPage.listWithNameExists(listName);
        mainPage.openListWithName(listName);
        assertThat(String.format("Product with name %s was added",
                productName), productsPage
                .productWithNameDoesNotExist(productName));
    }
}
