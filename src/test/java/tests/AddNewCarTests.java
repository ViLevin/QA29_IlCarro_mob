package tests;

import config.AppiumConfig;
import dto.RegistrationBodyDTO;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.LoginScreen;
import screens.SearchScreen;
import screens.SplashScreen;

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
        SearchScreen searchScreen = new SearchScreen(driver);
        searchScreen.clickBtnDots();
        searchScreen.clickBtnMyCars();
    }
}
