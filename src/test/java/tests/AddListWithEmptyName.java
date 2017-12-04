package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.MainPage;

import static org.hamcrest.MatcherAssert.assertThat;

public class AddListWithEmptyName extends AndroidSetup {

    private MainPage mainPage;

    @DataProvider(name = "Invalid list names")
    public static Object[][] listNames( ) {
        return new Object[][]{ { "" }, { "11" }, { "aa" }, { "!@" }, { "  "
        }, { "__" } };
    }

    @BeforeTest
    public void setUp( ) {
        mainPage = new MainPage(AndroidSetup.driver);
    }

    @Test(description = "[TC5] Check user cannot add a list with name shorter" +
            " " +
            "that 3 symbols", dataProvider = "Invalid list names")
    public void addNewList(String listName) {
        mainPage
                .headerDisplayed()
                .setTextIntoNewListField(listName)
                .clickAddButton();
        assertThat("List exists", mainPage.listDoesNotExist());
    }

    @AfterMethod
    public void restartApp() {
        driver.resetApp();
    }
}
