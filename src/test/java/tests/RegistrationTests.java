package tests;

import config.AppiumConfig;
import dto.RegistrationBodyDTO;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.ErrorScreen;
import screens.RegistrationScreen;
import screens.SearchScreen;
import screens.SplashScreen;

import java.util.Random;

public class RegistrationTests extends AppiumConfig {


    @Test
    public void registrationPositiveTest() {

        int i = new Random().nextInt(1000);
        RegistrationBodyDTO user = RegistrationBodyDTO.builder()
                .firstname("Johny" + i)
                .lastname("Green")
                .username("johnygreen" + i + "@gmail.com")
                .password("Zxcvb123!")
                .build();

        new SplashScreen(driver).goToSearchScreen(5);
        SearchScreen searchScreen = new SearchScreen(driver);
        searchScreen.clickBtnDots();
        searchScreen.clickBtnRegistration();
        RegistrationScreen registrationScreen = new RegistrationScreen(driver);
        registrationScreen.typeRegForm(user);
        registrationScreen.clickCheckBox();
        registrationScreen.clickBtnYalla();
        Assert.assertTrue(searchScreen.isTextInElement_popUpMessageSuccess("Registration success!"));
    }

    @Test
    public void registrationNegativeTest_WOCheckBox() {

        int i = new Random().nextInt(1000);
        RegistrationBodyDTO user = RegistrationBodyDTO.builder()
                .firstname("Johny" + i)
                .lastname("Green")
                .username("johnygreen" + i + "@gmail.com")
                .password("Zxcvb123!")
                .build();

        new SplashScreen(driver).goToSearchScreen(5);
        SearchScreen searchScreen = new SearchScreen(driver);
        searchScreen.clickBtnDots();
        searchScreen.clickBtnRegistration();
        RegistrationScreen registrationScreen = new RegistrationScreen(driver);
        registrationScreen.typeRegForm(user);
        registrationScreen.clickBtnYalla();

        Assert.assertTrue(new ErrorScreen(driver).validateErrorMessage("All fields must be filled and agree terms"));
    }

    @Test
    public void registrationNegativeTest() {

        int i = new Random().nextInt(1000);
        RegistrationBodyDTO user = RegistrationBodyDTO.builder()
                .firstname("Johny" + i)
                .lastname("Green")
                .username("johnygreen" + i + "gmail.com")
                .password("Zxcvb123!")
                .build();

        new SplashScreen(driver).goToSearchScreen(5);
        SearchScreen searchScreen = new SearchScreen(driver);
        searchScreen.clickBtnDots();
        searchScreen.clickBtnRegistration();
        RegistrationScreen registrationScreen = new RegistrationScreen(driver);
        registrationScreen.typeRegForm(user);
        registrationScreen.clickCheckBox();
        registrationScreen.clickBtnYalla();
        Assert.assertTrue(new ErrorScreen(driver).validateErrorMessage("{username=must be a well-formed email address}"));

    }

}
