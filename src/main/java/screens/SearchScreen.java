package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchScreen extends BaseScreen {
    public SearchScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='More options']")
    AndroidElement btnDots;
    @FindBy(xpath = "//*[@text='Registration']")
    AndroidElement btnRegistration;
    @FindBy(xpath = "//*[@text='Login']")
    AndroidElement btnLogin;
    @FindBy(xpath = "//hierarcy/android.widget.Toast")
    AndroidElement popUpMessageSuccess;


    public void clickBtnDots() {
        clickWait(btnDots, 3);
    }

    public void clickBtnRegistration() {
        clickWait(btnRegistration, 3);
    }

    public void clickBtnLogin() {
        clickWait(btnLogin, 3);
    }

    public boolean isTextInElement_popUpMessageSuccess(String text){
        return textElementPresent(popUpMessageSuccess, text,3);
    }

}