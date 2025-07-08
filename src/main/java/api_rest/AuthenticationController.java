package api_rest;

import dto.RegistrationBodyDTO;
import interfaces.BaseAPI;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AuthenticationController implements BaseAPI {
    public Response registrationLogin(RegistrationBodyDTO user, String url) {
        return given()
                .body(user)
                .contentType(ContentType.JSON)
                .when()
                .post(BASE_URL + url)
                .thenReturn();
    }

    public Response registrationLoginHTTP(RegistrationBodyDTO user, String url) {
        return given()
                .body(user)
                .contentType(ContentType.JSON)
                .when()
                .post(BASE_URL_HTTP + url)
                .thenReturn();
    }

}
