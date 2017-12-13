package steps;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import pages.CommonElements;
import pages.MainPage;

import static org.hamcrest.MatcherAssert.assertThat;

public class MainPageSteps extends AbstractStep {

    private MainPage mainPage = new MainPage(driver);

    private CommonElements commonElements = new CommonElements(driver);

    public MainPageSteps(AndroidDriver driver) {
        super(driver);
    }

    @Override
    @Step("App is opened")
    public MainPageSteps checkPageDisplayed() {
        mainPage.getMainPageHeader();
        assertThat("Add main page is not displayed", mainPage.getMainPageHeader
                ().isDisplayed());
        return this;
    }

    @Step("Check the specified list exists")
    public MainPageSteps listWithNameExists(String listName) {
        assertThat(String.format("List with name %s does not exist.", listName),
                driver
                        .findElementByXPath
                                (String.format
                                        (mainPage.getListByNameLocator(),
                                                listName)
                                ).isDisplayed());
        return this;
    }

    @Step("Open list with name")
    public MainPageSteps openListWithName(String listName) {
        driver.findElementByXPath(String.format(mainPage.getListByNameLocator(),
                listName)
        ).click();
        return this;
    }

    @Step("Check the list does not exist")
    public MainPageSteps listDoesNotExist() {
        assertThat("List exists.",
                driver.findElementsById("com.slava.buylist:id/rr1").isEmpty());
        return this;
    }

    @Step("Check the specified list does not exist")
    public MainPageSteps listWithNameDoesNotExist(String listName) {
        assertThat(String.format("List with name %s exists", listName), driver
                .findElementsByXPath(String.format(mainPage
                                .getListByNameLocator(),
                        listName)).isEmpty());
        return this;
    }

    @Step("Set list name to the field")
    public MainPageSteps setTextIntoNewListField(String listName) {
        mainPage.getListNameField().click();
        mainPage.getListNameField().sendKeys(listName);
        return this;
    }

    @Step("Click remove the specified list")
    public MainPageSteps deleteListWithName(String listName) {
        driver.findElementByXPath
                (String.format(mainPage.getRemoveListButton(), listName))
                .click();
        return this;
    }

    @Step("Click 'Yes' in the dialog window")
    public MainPageSteps confirmDeletingList() {
        mainPage.getYesButton().click();
        return this;
    }

    @Step("Click 'No' in the dialog window")
    public MainPageSteps cancelDeletingList() {
        mainPage.getNoButton().click();
        return this;
    }

    @Step("Click 'Edit' button for list with specified name")
    public MainPageSteps clickEditButtonListWithName(String listName) {
        WebElement editButton = driver.findElementByXPath(String.format
                (mainPage.getEditListButton(),
                listName));
        editButton.isDisplayed();
        editButton.click();
        return this;
    }

    @Step("Click 'Add new list' button")
    public MainPageSteps clickAddButton() {
        mainPage.getAddListButton().click();
        return this;
    }

    @Step("Open 'More' menu")
    public MainPageSteps clickMore() {
        commonElements.getMoreButton().click();
        return this;
    }
}
