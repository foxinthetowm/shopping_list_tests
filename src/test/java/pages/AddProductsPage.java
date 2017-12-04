package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

public class AddProductsPage extends Page {

    CommonElements commonElements = new CommonElements(driver);

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

    @Step("Check 'Add product' screen displayed")
    public boolean addProductScreenDisplayed( ) {
        return productNameField.isDisplayed();
    }

    @Step("Check product was added")
    public boolean productWithNameExists(String name) {
        WebElement productWithName = driver.findElementByXPath(format
                (productWithNameLoc, name));
        return productWithName.isDisplayed();
    }


    @Step("Check product was not added")
    public boolean productWithNameDoesNotExist(String name) {
        return driver.findElementsByXPath(format
                (productWithNameLoc, name)).isEmpty();
    }


    @Step("Check quantity is correct for added product")
    public boolean checkQuantityOfProductWithName(String productName, String
            expectedQty) {
        String qty = driver.findElementByXPath(
                format(productQty, productName)).getText();
        return qty.equals(expectedQty);
    }

    @Step("Check price is correct for added product")
    public boolean checkPriceOfProductWithName(String productName, String
            expectedPrice) {
        String price = driver.findElementByXPath(
                format(productPrice, productName)).getText();
        return price.contains(expectedPrice);
    }

    @Step("Check comment is correct for added product")
    public boolean checkCommentForProductWithName(String productName, String
            expectedComment) {
        String comment = driver.findElementByXPath(
                format(productComment, productName)).getText();
        return comment.equals(expectedComment);
    }

    @Step("Check total is correct")
    public boolean checkTotal(String expectedTotal) {
        String currentTotal = total.getText();
        return currentTotal.contains(expectedTotal);
    }

    @Step("Add new product")
    public AddProductsPage addNewProduct(String productName, String price,
                                         String amount, String testComment,
                                         String measure, String category) {
        setTextToProductNameField(productName);
        setTextToProductPriceField(price);
        setTextToProductAmountField(amount);
        setTextToProductCommentField(testComment);
        selectMeasure(measure);
        selectCategory(category);
        clickAddProductButton();
        return this;
    }

    @Step("Set text to the product name field")
    public AddProductsPage setTextToProductNameField(String productName) {
        productNameField.click();
        productNameField.sendKeys(productName);
        return this;
    }

    @Step("Set text to the product price field")
    public AddProductsPage setTextToProductPriceField(String productPrice) {
        productPriceField.click();
        productPriceField.sendKeys(productPrice);
        return this;
    }

    @Step("Set text to the product amount field")
    public AddProductsPage setTextToProductAmountField(String productAmount) {
        productAmountField.click();
        productAmountField.sendKeys(productAmount);
        return this;
    }

    @Step("Set text to the product comment field")
    public AddProductsPage setTextToProductCommentField(String productComment) {
        productCommentField.click();
        productCommentField.sendKeys(productComment);
        return this;
    }

    @Step("Select measure for product")
    public AddProductsPage selectMeasure(String productMeasure) {
        productMeasureSpinner.click();
        commonElements.selectItemWithName(productMeasure);
        return this;
    }

    @Step("Select category for product")
    public AddProductsPage selectCategory(String productCategory) {
        productCategorySpinner.click();
        commonElements.selectItemWithName(productCategory);
        return this;
    }

    @Step("Click 'Add product' button")
    public AddProductsPage clickAddProductButton( ) {
        addProductButton.click();
        return this;
    }

    @Step("Open 'More' menu")
    public AddProductsPage clickMore( ) {
        commonElements.clickMore();
        return this;
    }

    @Step("Check sorting")
    public List<String> getOrderedProductList( ) {
        List<WebElement> elements = driver.findElementsByXPath(anyProductLoc);
        List<String> currentSorting = new ArrayList<>();
        for (WebElement element : elements) {
            currentSorting.add(element.getText());
        }
        return currentSorting;
    }
}

