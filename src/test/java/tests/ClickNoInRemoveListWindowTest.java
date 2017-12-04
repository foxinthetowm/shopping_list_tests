package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.MainPage;

import static org.hamcrest.MatcherAssert.assertThat;

public class ClickNoInRemoveListWindowTest extends AndroidSetup {

    private final String listName = "New list2";

    private MainPage mainPage;

    @BeforeTest
    public void setUp( ) {
        mainPage = new MainPage(driver);
    }

    @Test(description = "TC6: Cancel shopping list deleting")
    public void removeNewList( ) {
        mainPage.headerDisplayed();
        mainPage.setTextIntoNewListField(listName);
        mainPage.clickAddButton();
        mainPage.pressBackTwice();
        mainPage.listWithNameExists(listName);
        mainPage.deleteListWithName(listName).cancelDeletingList();
        assertThat(String.format("List with name %s exists", listName)
                , mainPage
                        .listWithNameExists(listName));
    }
}
