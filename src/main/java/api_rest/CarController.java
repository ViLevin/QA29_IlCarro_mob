package api_rest;

import dto.CarDTO;
import dto.RegistrationBodyDTO;
import dto.TokenDto;
import interfaces.BaseAPI;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.given;

public class CarController implements BaseAPI {
    public TokenDto tokenDto;

    @BeforeSuite
    public void login() {
        RegistrationBodyDTO user = RegistrationBodyDTO.builder()
                .username("test12@gmail.com")
                .password("vilevinQa!1234")
                .build();
        tokenDto = given().body(user).contentType(ContentType.JSON).when().post(BASE_URL + LOGIN_URL).thenReturn().getBody().as(TokenDto.class);
        System.out.println(tokenDto.getAccessToken());
    }

    public Response addNewCar(CarDTO car){
        return given().body(car).contentType(ContentType.JSON).header("Authorization", tokenDto.getAccessToken()).when().post(BASE_URL+ ADD_NEW_CAR_URL).thenReturn();
    }
}
