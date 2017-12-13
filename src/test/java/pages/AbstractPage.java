package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 * A base for all the pages
 */
public abstract class AbstractPage {

    protected final AndroidDriver driver;

    protected AbstractPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, 20, TimeUnit
                .SECONDS), this);
    }
}
