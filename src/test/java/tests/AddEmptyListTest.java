package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import steps.CommonSteps;
import steps.MainPageSteps;

public class AddEmptyListTest extends AbstractShoppingListTest {

    private MainPageSteps mainPageSteps;

    private CommonSteps commonSteps;

    @DataProvider(name = "Valid list names")
    public static Object[][] listNames() {
        return new Object[][]{{"list"}, {"List name"}, {"aaa"}, {
                "!@!"}, {"   "}, {"Is it 30 symbols string? Yep!!"}};
    }

    @BeforeTest
    public void setUp() {
        mainPageSteps = new MainPageSteps(driver);
        commonSteps = new CommonSteps(driver);
    }

    @Test(description = "[TC1] Add an empty shopping list", dataProvider =
            "Valid list names")
    public void addEmptyList(String listName) {
        mainPageSteps
                .checkPageDisplayed()
                .setTextIntoNewListField(listName)
                .clickAddButton();
        commonSteps.pressBackTwice();
        mainPageSteps.listWithNameExists(listName);
    }

    @AfterMethod
    public void restartApp() {
        driver.resetApp();
    }
}
