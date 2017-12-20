package steps;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import pages.CommonElements;
import pages.ShoppingListsPage;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 *  Steps for Shopping List Page
 */
public class ShoppingListPageSteps extends AbstractStep {

    private ShoppingListsPage shoppingListsPage = new ShoppingListsPage(driver);

    private CommonElements commonElements = new CommonElements(driver);

    private CommonSteps commonSteps = new CommonSteps(driver);

    public ShoppingListPageSteps(AndroidDriver driver) {
        super(driver);
    }

    @Override
    @Step("App is opened")
    public ShoppingListPageSteps checkPageDisplayed() {
        shoppingListsPage.getMainPageHeader();
        assertThat("Add main page is not displayed", shoppingListsPage.getMainPageHeader
                ().isDisplayed());
        return this;
    }

    @Step("Check the specified list exists")
    public ShoppingListPageSteps listWithNameExists(String listName) {
        assertThat(String.format("List with name %s does not exist.", listName),
                driver
                        .findElementByXPath
                                (String.format
                                        (shoppingListsPage.getListByNameLocator(),
                                                listName)
                                ).isDisplayed());
        return this;
    }

    @Step("Open list with name")
    public ShoppingListPageSteps openListWithName(String listName) {
        driver.findElementByXPath(String.format(shoppingListsPage.getListByNameLocator(),
                listName)
        ).click();
        return this;
    }

    @Step("Check the list does not exist")
    public ShoppingListPageSteps listDoesNotExist() {
        assertThat("List exists.",
                driver.findElementsById("com.slava.buylist:id/rr1").isEmpty());
        return this;
    }

    @Step("Check the specified list does not exist")
    public ShoppingListPageSteps listWithNameDoesNotExist(String listName) {
        assertThat(String.format("List with name %s exists", listName), driver
                .findElementsByXPath(String.format(shoppingListsPage
                                .getListByNameLocator(),
                        listName)).isEmpty());
        return this;
    }

    @Step("Set list name to the field")
    public ShoppingListPageSteps setTextIntoNewListField(String listName) {
        shoppingListsPage.getListNameField().click();
        shoppingListsPage.getListNameField().sendKeys(listName);
        return this;
    }

    @Step("Click remove the specified list")
    public ShoppingListPageSteps deleteListWithName(String listName) {
        driver.findElementByXPath
                (String.format(shoppingListsPage.getRemoveListButton(), listName))
                .click();
        return this;
    }

    @Step("Click 'Yes' in the dialog window")
    public ShoppingListPageSteps confirmDeletingList() {
        shoppingListsPage.getYesButton().click();
        return this;
    }

    @Step("Click 'No' in the dialog window")
    public ShoppingListPageSteps cancelDeletingList() {
        shoppingListsPage.getNoButton().click();
        return this;
    }

    @Step("Click 'Edit' button for list with specified name")
    public ShoppingListPageSteps clickEditButtonListWithName(String listName) {
        WebElement editButton = driver.findElementByXPath(String.format
                (shoppingListsPage.getEditListButton(),
                listName));
        commonSteps.waitUntilDisplayed(editButton);
        editButton.click();
        return this;
    }

    @Step("Click 'Add new list' button")
    public ShoppingListPageSteps clickAddButton() {
        shoppingListsPage.getAddListButton().click();
        return this;
    }

    @Step("Open 'More' menu")
    public ShoppingListPageSteps clickMore() {
        commonElements.getMoreButton().click();
        return this;
    }
}
