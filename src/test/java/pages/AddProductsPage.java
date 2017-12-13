package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AddProductsPage extends AbstractPage {

    @AndroidFindBy(id = "com.slava.buylist:id/editText1")
    private MobileElement productNameField;

    @AndroidFindBy(id = "com.slava.buylist:id/button2")
    private MobileElement addProductButton;

    @AndroidFindBy(id = "com.slava.buylist:id/editText2")
    private MobileElement productPriceField;

    @AndroidFindBy(id = "com.slava.buylist:id/editText3")
    private MobileElement productAmountField;

    @AndroidFindBy(id = "com.slava.buylist:id/editText4")
    private MobileElement productCommentField;

    @AndroidFindBy(id = "com.slava.buylist:id/textView2")
    private MobileElement total;

    @AndroidFindBy(xpath = "//android.widget.Spinner[@resource-id='com.slava" +
            ".buylist:id/spinner1']/android.widget.TextView")
    private MobileElement productMeasureSpinner;

    @AndroidFindBy(xpath = "//android.widget.Spinner[@resource-id='com.slava" +
            ".buylist:id/spinner2']/android.widget.TextView")
    private MobileElement productCategorySpinner;

    private String productWithNameLoc = "//android.widget.TextView[@text='%s']";

    private String anyProductLoc = "//android.widget" +
            ".TextView[@resource-id='com.slava.buylist:id/title']";

    private String productQty = "//android.widget.RelativeLayout[android" +
            ".widget.TextView[@text='%s']]/android.widget" +
            ".TextView[@resource-id='com.slava.buylist:id/TextView01']";

    private String productPrice = "//android.widget.RelativeLayout[android" +
            ".widget.TextView[@text='%s']]/android.widget" +
            ".TextView[@resource-id='com.slava.buylist:id/textView1']";

    private String productComment = "//android.widget.RelativeLayout[android" +
            ".widget.TextView[@text='%s']]/android.widget" +
            ".TextView[@resource-id='com.slava.buylist:id/str1']";

    public AddProductsPage(AndroidDriver driver) {
        super(driver);
    }

    public MobileElement getProductNameField() {
        return productNameField;
    }

    public MobileElement getAddProductButton() {
        return addProductButton;
    }

    public MobileElement getProductPriceField() {
        return productPriceField;
    }

    public MobileElement getProductAmountField() {
        return productAmountField;
    }

    public MobileElement getProductCommentField() {
        return productCommentField;
    }

    public MobileElement getTotal() {
        return total;
    }

    public MobileElement getProductMeasureSpinner() {
        return productMeasureSpinner;
    }

    public MobileElement getProductCategorySpinner() {
        return productCategorySpinner;
    }

    public String getProductWithNameLoc() {
        return productWithNameLoc;
    }

    public String getAnyProductLoc() {
        return anyProductLoc;
    }

    public String getProductQty() {
        return productQty;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public String getProductComment() {
        return productComment;
    }
}

