package tests;

import config.AppiumConfig;
import dto.CarDTO;
import dto.RegistrationBodyDTO;
import enums.Fuel;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.*;

import java.util.Random;

import static config.AppiumConfig.height;
import static config.AppiumConfig.width;

public class AddNewCarTests extends AppiumConfig {

    @BeforeMethod
    public void login() {
        RegistrationBodyDTO user = RegistrationBodyDTO.builder().username("test12@gmail.com").password("vilevinQa!1234").build();
        new SplashScreen(driver).goToSearchScreen(10);
        SearchScreen searchScreen = new SearchScreen(driver);
        searchScreen.clickBtnDots();
        searchScreen.clickBtnLogin();
        LoginScreen loginScreen = new LoginScreen(driver);
        loginScreen.typeLoginForm(user);
        loginScreen.clickBtnLogin();
    }

    @Test
    public void addNewCarPossitiveTest() {
        int i = new Random().nextInt(1000) + 1000;
        CarDTO car = CarDTO.builder()
                .serialNumber("963-" + i + "368")
                .manufacture("Honda")
                .model("Civic")
                .year("2025")
                .fuel(Fuel.HYBRID.getFuel())
                .seats(5)
                .carClass("C")
                .pricePerDay(75.0)
                .city("Tel Aviv")
                .about("The best car")
                .build();

        SearchScreen searchScreen = new SearchScreen(driver);
        searchScreen.clickBtnDots();
        searchScreen.clickBtnMyCars();
        MyCarScreen myCarScreen = new MyCarScreen(driver);
        myCarScreen.clickBtnAddNewCar();
        AddNewCarScreen addNewCarScreen = new AddNewCarScreen(driver);
        addNewCarScreen.typeAddNewCarForm(car);
        addNewCarScreen.clickBtnAddCar();

        Assert.assertTrue(new MyCarScreen(driver).isTextInElement_popUpMessageSuccess("Car was added!"));
    }


}
