package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import steps.AddProductPageSteps;
import steps.CommonSteps;
import steps.DialogWindowSteps;
import steps.MainPageSteps;

public class DoNotSaveProductTest extends AbstractShoppingListTest {

    private MainPageSteps mainPageSteps;

    private AddProductPageSteps addProductPageSteps;

    private DialogWindowSteps dialogWindowSteps;

    private CommonSteps commonSteps;

    @DataProvider(name = "Products parameters")
    public static Object[][] listNames() {
        return new Object[][]{{"New list", "product1", "2", "5", "comment",
                "kg.", "Pet products"}};
    }

    @BeforeTest
    private void setUp() {
        mainPageSteps = new MainPageSteps(AbstractShoppingListTest.driver);
        addProductPageSteps = new AddProductPageSteps(driver);
        dialogWindowSteps = new DialogWindowSteps(driver);
        commonSteps = new CommonSteps(driver);
    }

    @Test(description = "[TC8] Create a list but do not save a new product",
            dataProvider = "Products parameters")
    public void doNotSaveNewProduct(String listName,
                                    String productName,
                                    String price,
                                    String amount,
                                    String testComment,
                                    String measure,
                                    String category) {
        mainPageSteps
                .checkPageDisplayed()
                .setTextIntoNewListField(listName)
                .clickAddButton();
        addProductPageSteps.checkPageDisplayed();
        addProductPageSteps.setTextToProductNameField(productName)
                .setTextToProductPriceField(price)
                .setTextToProductAmountField(amount)
                .setTextToProductCommentField(testComment)
                .selectMeasure(measure)
                .selectCategory(category);
        commonSteps.pressBackTwice();
        dialogWindowSteps.clickNo();
        mainPageSteps.listWithNameExists(listName);
        mainPageSteps.openListWithName(listName);
        addProductPageSteps
                .productWithNameDoesNotExist(productName);
    }
}
