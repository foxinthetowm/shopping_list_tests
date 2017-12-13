package steps;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import pages.AddProductsPage;
import pages.CommonElements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.String.format;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 *  Steps for Add Product Page
 */
public class AddProductPageSteps extends AbstractStep {

    private AddProductsPage addProductsPage = new AddProductsPage(driver);

    private CommonElements commonElements = new CommonElements(driver);

    private SoftAssert softAssertion = new SoftAssert();

    public AddProductPageSteps(AndroidDriver driver) {
        super(driver);
    }

    @Override
    @Step("Check 'Add product' screen displayed")
    public AddProductPageSteps checkPageDisplayed() {
        assertThat("Add product page is not displayed", addProductsPage
                .getProductNameField().isDisplayed());
        return this;
    }

    @Step("Check product was added")
    public AddProductPageSteps productWithNameExists(String name) {
        WebElement productWithName = driver.findElementByXPath(format
                (addProductsPage.getProductWithNameLoc(), name));
        assertThat(String.format("Product with name %s is not exist", name),
                productWithName.isDisplayed());
        return this;
    }

    @Step("Check product was not added")
    public AddProductPageSteps productWithNameDoesNotExist(String name) {
        assertThat(String.format("Product with name %s exists", name), driver
                .findElementsByXPath(format
                        (addProductsPage.getProductWithNameLoc(), name))
                .isEmpty());
        return this;
    }

    @Step("Check total is correct")
    public AddProductPageSteps checkTotal(String expectedTotal) {
        String currentTotal = addProductsPage.getTotal().getText();
        assertThat("Total is not correct", currentTotal.contains
                (expectedTotal));
        return this;
    }

    @Step("Add new product")
    public AddProductPageSteps addNewProduct(String productName, String price,
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
    public AddProductPageSteps setTextToProductNameField(String productName) {
        addProductsPage.getProductNameField().click();
        addProductsPage.getProductNameField().sendKeys(productName);
        return this;
    }

    @Step("Set text to the product price field")
    public AddProductPageSteps setTextToProductPriceField(String productPrice) {
        addProductsPage.getProductPriceField().click();
        addProductsPage.getProductPriceField().sendKeys(productPrice);
        return this;
    }

    @Step("Set text to the product amount field")
    public AddProductPageSteps setTextToProductAmountField(String productAmount) {
        addProductsPage.getProductAmountField().click();
        addProductsPage.getProductAmountField().sendKeys(productAmount);
        return this;
    }

    @Step("Set text to the product comment field")
    public AddProductPageSteps setTextToProductCommentField(String productComment) {
        addProductsPage.getProductCommentField().click();
        addProductsPage.getProductCommentField().sendKeys(productComment);
        return this;
    }

    @Step("Select measure for product")
    public AddProductPageSteps selectMeasure(String productMeasure) {
        addProductsPage.getProductMeasureSpinner().click();
        driver.findElementByXPath(format(commonElements
                .getItemInDropDownWithName(), productMeasure))
                .click();
        return this;
    }

    @Step("Select category for product")
    public AddProductPageSteps selectCategory(String productCategory) {
        addProductsPage.getProductCategorySpinner().click();
        driver.findElementByXPath(format(commonElements
                .getItemInDropDownWithName(), productCategory))
                .click();
        return this;
    }

    @Step("Click 'Add product' button")
    public AddProductPageSteps clickAddProductButton() {
        addProductsPage.getAddProductButton().click();
        return this;
    }

    @Step("Open 'More' menu")
    public AddProductPageSteps clickMore() {
        commonElements.getMoreButton().click();
        return this;
    }

    @Step("Check sorting")
    public AddProductPageSteps getOrderedProductList(String[]
                                                             expectedSorting) {
        List<WebElement> elements = driver.findElementsByXPath
                (addProductsPage.getAnyProductLoc());
        List<String> currentSorting = new ArrayList<>();
        for (WebElement element : elements) {
            currentSorting.add(element.getText());
        }
        assertThat("Products have wrong order", Arrays.asList
                (expectedSorting).equals(currentSorting));
        return this;
    }

    @Step("Check price is correct for added product")
    public AddProductPageSteps checkPriceOfProductWithName(String productName, String
            expectedPrice) {
        assertThat("Price is incorrect", getProductPrice(productName).contains
                (expectedPrice));
        return this;
    }

    private String getProductPrice(String productName) {
        return driver.findElementByXPath(
                format(addProductsPage.getProductPrice(), productName))
                .getText();
    }

    @Step("Check comment is correct for added product")
    public AddProductPageSteps checkCommentForProductWithName(String productName, String
            expectedComment) {
        assertThat("Comment is not correct", getProductComment(productName)
                .equals
                        (expectedComment));
        return this;
    }

    private String getProductComment(String productName) {
        return driver.findElementByXPath(
                format(addProductsPage.getProductComment(), productName))
                .getText();
    }

    @Step("Check quantity is correct for added product")
    public AddProductPageSteps checkQuantityOfProductWithName(String productName, String
            expectedQty) {
        assertThat("Quantity is incorrect", getProductQty(productName).equals
                (expectedQty));
        return this;
    }

    private String getProductQty(String productName) {
        return driver.findElementByXPath(
                format(addProductsPage.getProductQty(), productName))
                .getText();
    }

    @Step("Check product parameters: quantity, price, comment")
    public AddProductPageSteps checkProductParameters(String productName,
                                                      String expectedAmount,
                                                      String expectedMeasure,
                                                      String expectedPrice,
                                                      String expectedComment) {
        WebElement product = driver.findElementByXPath(format
                (addProductsPage.getProductWithNameLoc(), (productName)));
        softAssertion.assertTrue(product.isDisplayed());
        softAssertion.assertTrue(getProductQty(productName).equals
                (expectedAmount + " " +
                        expectedMeasure));
        softAssertion.assertTrue(getProductPrice(productName).contains
                (expectedPrice));
        softAssertion.assertTrue(getProductComment(productName).equals
                (expectedComment));
        softAssertion.assertAll();
        return this;
    }
}
