package rest;

import api_rest.CarController;
import dto.CarsDTO;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class GetAllUserCarsTests extends CarController {
    CarsDTO cars;
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void getUserCars_PositiveTest() {
        Response response = getAllUserCars();
        cars = response.getBody().as(CarsDTO.class);
        System.out.println(cars);
        softAssert.assertEquals(response.getStatusCode(), 200);
        softAssert.assertTrue(cars.getCars()[0].getCarClass().contains("a"), "validate CarClass");
        softAssert.assertAll();
    }

    @Test
    public void getUserCarsNegativeTest_WrongURL() {
        Response response = getAllUserCarsNegative_WrongURL(LOGIN_URL);
        System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 403);
    }

}
