package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.MainPage;

import static org.hamcrest.MatcherAssert.assertThat;

public class AddEmptyListTest extends AndroidSetup {

    private MainPage mainPage;

    @DataProvider(name = "Valid list names")
    public static Object[][] listNames() {
        return new Object[][]{ { "list" }, { "List name" }, { "aaa" }, {
                "!@!" }, { "   " }, { "Is it 30 symbols string? Yep!!" } };
    }

    @BeforeTest
    public void setUp() {
        mainPage = new MainPage(AndroidSetup.driver);
    }

    @Test(description = "[TC1] Add an empty shopping list", dataProvider =
            "Valid list names")
    public void addNewList(String listName) {
        mainPage
                .headerDisplayed()
                .setTextIntoNewListField(listName)
                .clickAddButton()
                .pressBackTwice();
        assertThat(String.format("List with name %s does not exist",
                listName), mainPage
                .listWithNameExists(listName));
    }

    @AfterMethod
    public void restartApp() {
        driver.resetApp();
    }
}
