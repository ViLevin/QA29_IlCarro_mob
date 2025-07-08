package rest;

import api_rest.AuthenticationController;
import com.google.errorprone.annotations.RestrictedApi;
import dto.RegistrationBodyDTO;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

public class LoginTestsRest extends AuthenticationController {
    RegistrationBodyDTO user;


    @BeforeClass
    public void registrationUser() {
        int i = new Random().nextInt(1000);
        user = RegistrationBodyDTO.builder()
                .username("test" + i + "@gmail.com")
                .password("vilevinQa!1234")
                .firstName("Tes")
                .lastName("Ter")
                .build();
        System.out.println("result registration -->"+registrationLogin(user, REGISTRATION_URL).getStatusCode());
    }

    @Test
    public void loginPositiveTest() {
        Assert.assertEquals(registrationLogin(user, LOGIN_URL).getStatusCode(), 200);
    }

    @Test
    public void loginNegativeTest_EmptyEmail(){
        user.setUsername("");
        Response response = registrationLogin(user, LOGIN_URL);
        Assert.assertEquals(response.getStatusCode(), 401);//bad code response
    }

    @Test
    public void loginNegativeTest_UnregosteredUser_WrongEmail(){
        user.setUsername("0535592367vi@gmail.com");
        Response response = registrationLogin(user, LOGIN_URL);
        Assert.assertEquals(response.getStatusCode(), 401);
    }

    @Test
    public void loginNegativeTest_EmptyPassword(){
        user.setPassword("");
        Response response = registrationLogin(user,LOGIN_URL);
        Assert.assertEquals(response.getStatusCode(), 401);//bad code response
    }

    @Test
    public void loginNegativeTest_WrongPassword(){
        user.setPassword("vilevinQa1234");
        Response response = registrationLogin(user, LOGIN_URL);
        Assert.assertEquals(response.getStatusCode(), 401);//bad code response
    }


}
