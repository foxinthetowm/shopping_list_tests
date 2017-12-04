package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.MainPage;

import static java.lang.String.format;
import static org.hamcrest.MatcherAssert.assertThat;

public class RemoveListTest extends AndroidSetup {

    private final String listName = "New list2";

    private MainPage mainPage;

    @BeforeTest
    public void setUp( ) {
        mainPage = new MainPage(driver);
    }

    @Test(description = "TC4: Remove shopping list")
    public void removeNewList( ) {
        mainPage.headerDisplayed();
        mainPage.setTextIntoNewListField(listName).clickAddButton()
                .pressBackTwice();
        mainPage.listWithNameExists(listName);
        mainPage.deleteListWithName(listName).confirmDeletingList();
        assertThat(format("List with name %s exists", listName),
                mainPage
                        .listWithNameDoesNotExist(listName));
    }
}
