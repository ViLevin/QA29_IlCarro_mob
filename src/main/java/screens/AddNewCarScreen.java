package screens;

import dto.CarDTO;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static config.AppiumConfig.height;
import static config.AppiumConfig.width;

public class AddNewCarScreen extends BaseScreen {
    public AddNewCarScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }

//    private String serialNumber;
//    private String manufacture;
//    private String model;
//    private String year;
//    private String fuel;
//    private int seats;
//    private String carClass;
//    private String pricePerDay;
//    private String about;
//    private String city;

    @FindBy(id = "com.telran.ilcarro:id/editSerial")
    AndroidElement fieldSeralNumber;
    @FindBy(id = "com.telran.ilcarro:id/editMan")
    AndroidElement fieldManufacture;
    @FindBy(id = "com.telran.ilcarro:id/editModel")
    AndroidElement fieldModel;
    @FindBy(id = "com.telran.ilcarro:id/editCity")
    AndroidElement fieldCity;
    @FindBy(id = "com.telran.ilcarro:id/editPrice")
    AndroidElement fieldPricePerDay;
    @FindBy(id = "com.telran.ilcarro:id/editCarClass")
    AndroidElement fieldCarClass;

    @FindBy(id = "com.telran.ilcarro:id/text1")
    AndroidElement fieldFuel;
    @FindBy(id = "com.telran.ilcarro:id/editYear")
    AndroidElement fieldYear;
    @FindBy(id = "com.telran.ilcarro:id/editSeats")
    AndroidElement fieldSeats;
    @FindBy(id = "com.telran.ilcarro:id/editAbout")
    AndroidElement fieldAbout;

    @FindBy(id = "com.telran.ilcarro:id/addCarBtn")
    AndroidElement btnAddCar;

    public void typeAddNewCarForm(CarDTO car) {
        fieldSeralNumber.sendKeys(car.getSerialNumber());
        fieldManufacture.sendKeys(car.getManufacture());
        fieldModel.sendKeys(car.getModel());
        fieldCity.sendKeys(car.getCity());
        fieldPricePerDay.sendKeys(car.getPricePerDay() + "");
        fieldCarClass.sendKeys(car.getCarClass());
        System.out.println(height + "x" + width);
        TouchAction<?> touchAction = new TouchAction<>(driver);
        touchAction.longPress(PointOption.point(width / 100, height / 4 * 3)).moveTo(PointOption.point(width / 100, height / 4)).release().perform();
        typeFuel(car.getFuel());
        fieldYear.sendKeys(car.getYear());
        fieldSeats.sendKeys(Integer.toString(car.getSeats()));
        fieldAbout.sendKeys(car.getAbout());
    }

    private void typeFuel(String fuel) {
        fieldFuel.click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='" + fuel + "']"))).click();
    }

    public void clickBtnAddCar() {
        btnAddCar.click();
    }

}
