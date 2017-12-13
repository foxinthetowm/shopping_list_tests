package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * A page representing shipping lists and Add New List form
 */
public class ShoppingListsPage extends AbstractPage {

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

    public ShoppingListsPage(AndroidDriver driver) {
        super(driver);
    }

    public MobileElement getListNameField() {
        return listNameField;
    }

    public MobileElement getAddListButton() {
        return addListButton;
    }

    public MobileElement getAnyShoppingList() {
        return anyShoppingList;
    }

    public MobileElement getYesButton() {
        return yesButton;
    }

    public MobileElement getNoButton() {
        return noButton;
    }

    public MobileElement getMainPageHeader() {
        return mainPageHeader;
    }

    public String getListByNameLocator() {
        return listByNameLocator;
    }

    public String getRemoveListButton() {
        return removeListButton;
    }

    public String getEditListButton() {
        return editListButton;
    }
}
