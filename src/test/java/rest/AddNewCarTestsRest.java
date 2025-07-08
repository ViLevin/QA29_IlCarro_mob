package rest;

import api_rest.CarController;
import dto.CarDTO;
import enums.Fuel;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Random;

public class AddNewCarTestsRest extends CarController {

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void addNewCarPossitiveTest() {
        int i = new Random().nextInt(1000) + 1000;
        CarDTO car = CarDTO.builder()
                .serialNumber("321" + i + "654")
                .manufacture("Honda")
                .model("Civic")
                .year("2024")
                .fuel(Fuel.HYBRID.getFuel())
                .seats(5)
                .carClass("B")
                .pricePerDay(55.5)
                .city("Tel Aviv")
                .build();
        Response response = addNewCar(car);
        softAssert.assertEquals(response.getStatusCode(), 200);
        System.out.println(response.getBody().print());
        softAssert.assertTrue(response.getBody().print().contains("Car added successfully"));
        softAssert.assertAll();
    }
}
