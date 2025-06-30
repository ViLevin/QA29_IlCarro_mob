package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.FindBy;

public class MyCarScreen extends BaseScreen {
    public MyCarScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/addCarBtn']")
    AndroidElement btnAddNewCar;
    @FindBy(xpath = "//hierarchy/android.widget.Toast")
    AndroidElement popUpMessageSuccess;


    public void clickBtnAddNewCar() {
        clickWait(btnAddNewCar, 5);
    }

    public boolean isTextInElement_popUpMessageSuccess(String text) {
        return textElementPresent(popUpMessageSuccess, text, 3);
    }

}