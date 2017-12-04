package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;

public class MainPage extends Page {

    CommonElements commonElements = new CommonElements(driver);

    @AndroidFindBy(xpath = "//android.widget.EditText")
    private MobileElement listNameField;

    @AndroidFindBy(id = "com.slava.buylist:id/button2")
    private MobileElement addListButton;

    @AndroidFindBy(id = "com.slava.buylist:id/rr1")
    private MobileElement anyShoppingList;

    @AndroidFindBy(id = "android:id/button1")
    private MobileElement yesButton;

    @AndroidFindBy(id = "android:id/button2")
    private MobileElement noButton;

    @AndroidFindBy(id = "com.slava.buylist:id/textView1")
    private MobileElement mainPageHeader;

    private String listByNameLocator = "//android.widget.TextView[@text='%s']";

    private String removeListButton = "//android.widget" +
            ".RelativeLayout[android.widget.TextView[@text='%s']]/android" +
            ".widget.ImageView[@resource-id='com.slava.buylist:id/imageView1']";

    private String editListButton = "//android.widget.RelativeLayout[android" +
            ".widget.TextView[@text='%s']]/android.widget" +
            ".ImageView[@resource-id='com.slava.buylist:id/imageView2']";

    public MainPage(AndroidDriver driver) {
        super(driver);
    }

    @Step("App is opened")
    public MainPage headerDisplayed() {
        mainPageHeader.isDisplayed();
        return this;
    }

    @Step("Check the specified list exists")
    public boolean listWithNameExists(String listName) {
        return driver.findElementByXPath(String.format(listByNameLocator,
                listName)
        ).isDisplayed();
    }

    @Step("Open list with name")
    public MainPage openListWithName(String listName) {
        driver.findElementByXPath(String.format(listByNameLocator, listName)
        ).click();
        return this;
    }

    @Step("Check the list does not exist")
    public boolean listDoesNotExist() {
        return driver.findElementsById("com.slava.buylist:id/rr1").isEmpty();
    }

    @Step("Check the specified list does not exist")
    public boolean listWithNameDoesNotExist(String listName) {
        return driver.findElementsByXPath(String.format(listByNameLocator,
                listName)).isEmpty();
    }

    @Step("Set list name to the field")
    public MainPage setTextIntoNewListField(String listName) {
        listNameField.click();
        listNameField.sendKeys(listName);
        return this;
    }

    @Step("Click remove the specified list")
    public MainPage deleteListWithName(String listName) {
        driver.findElementByXPath
                (String.format(removeListButton, listName)).click();
        return this;
    }

    @Step("Click 'Yes' in the dialog window")
    public MainPage confirmDeletingList() {
        yesButton.click();
        return this;
    }


    @Step("Click 'No' in the dialog window")
    public MainPage cancelDeletingList() {
        noButton.click();
        return this;
    }


    @Step("Click 'Edit' button for list with specified name")
    public MainPage clickEditButtonListWithName(String listName) {
        driver.findElementByXPath(String.format(editListButton, listName))
                .click();
        return this;
    }

    @Step("Click 'Add new list' button")
    public MainPage clickAddButton() {
        addListButton.click();
        return this;
    }

    @Step("Open 'More' menu")
    public MainPage clickMore() {
        commonElements.clickMore();
        return this;
    }
}
