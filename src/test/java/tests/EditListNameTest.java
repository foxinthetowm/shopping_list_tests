package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.DialogWindow;
import pages.MainPage;

import static org.hamcrest.MatcherAssert.assertThat;

public class EditListNameTest extends AbstractShoppingListTest {

    private final String oldName = "New list";

    private final String newName = "New list2";

    private MainPage mainPage;

    private DialogWindow editListWindow;

    @BeforeTest
    public void setUp( ) {
        mainPage = new MainPage(driver);
        editListWindow = new DialogWindow(driver);
        mainPage.headerDisplayed();
        mainPage.setTextIntoNewListField(oldName).clickAddButton()
                .pressBackTwice();
        mainPage.listWithNameExists(oldName);
    }

    @Test(description = "[TC3] Edit list: edit name")
    public void editListName( ) {
        mainPage.clickEditButtonListWithName(oldName);
        editListWindow.setTextToTheNameField(newName).clickOk();
        assertThat(String.format("List with name %s does not exist", newName),
                mainPage
                        .listWithNameExists(newName));
    }
}
