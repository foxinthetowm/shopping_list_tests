package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class Page {

    protected final AndroidDriver driver;

    protected Page(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit
                .SECONDS), this);
    }

    @Step("Press system Back button twice")
    public Page pressBackTwice() {
        driver.sendKeyEvent(AndroidKeyCode.BACK);
        driver.sendKeyEvent(AndroidKeyCode.BACK);
        return this;
    }

    @Step("Press system Back button")
    public Page pressBack() {
        driver.sendKeyEvent(AndroidKeyCode.BACK);
        return this;
    }

    @Step("Get orientation")
    public String getOrientation() {
        return driver.getOrientation().toString();
    }
}
