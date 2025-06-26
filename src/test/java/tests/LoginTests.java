package tests;

import config.AppiumConfig;
import dto.RegistrationBodyDTO;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.ErrorScreen;
import screens.LoginScreen;
import screens.SearchScreen;
import screens.SplashScreen;

public class LoginTests extends AppiumConfig {
    @BeforeMethod
    public void openLoginScreen() {
        new SplashScreen(driver).goToSearchScreen(10);
        SearchScreen searchScreen = new SearchScreen(driver);
        searchScreen.clickBtnDots();
        searchScreen.clickBtnLogin();
    }

    @Test
    public void loginPositiveTest() {
        RegistrationBodyDTO user = RegistrationBodyDTO.builder().username("test12@gmail.com").password("vilevinQa!1234").build();
        LoginScreen loginScreen = new LoginScreen(driver);
        loginScreen.typeLoginForm(user);
        loginScreen.clickBtnLogin();
        Assert.assertTrue(new SearchScreen(driver).isTextInElement_popUpMessageSuccess("Login success!"));
    }

    @Test
    public void loginNegativeTest_WrongEmail() {
        RegistrationBodyDTO user = RegistrationBodyDTO.builder().username("test12@gmai.com").password("vilevinQa!1234").build();
        LoginScreen loginScreen = new LoginScreen(driver);
        loginScreen.typeLoginForm(user);
        loginScreen.clickBtnLogin();
        Assert.assertTrue(new ErrorScreen(driver).validateErrorMessage("Login or Password incorrect"));
    }

    @Test
    public void loginNegativeTest_EmptyPassword() {
        RegistrationBodyDTO user = RegistrationBodyDTO.builder().username("test12@gmail.com").password("").build();
        LoginScreen loginScreen = new LoginScreen(driver);
        loginScreen.typeLoginForm(user);
        loginScreen.clickBtnLogin();
        Assert.assertTrue(new ErrorScreen(driver).validateErrorMessage("All fields must be filled and agree terms"));
    }
}
