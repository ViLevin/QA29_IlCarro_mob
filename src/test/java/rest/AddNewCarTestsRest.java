package rest;

import api_rest.CarController;
import dto.CarDTO;
import dto.ErrorMessageDtoString;
import enums.Fuel;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Random;

public class AddNewCarTestsRest extends CarController {

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void addNewCarPositiveTest() {
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

    @Test
    public void addNewCarNegativeTest_WrongAuth() {
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
        Response response = addNewCarWrongToken(car, "qwerrtyuiop12347asdfghjkl");
        System.out.println(response.print());
        softAssert.assertEquals(response.getStatusCode(), 401, "validate status code");
        System.out.println(response.getBody().print());
        softAssert.assertTrue(response.getBody().print().contains("strings must contain exactly"), "validate message");
        softAssert.assertAll();
    }

    @Test
    public void addNewCarNegativeTest_WithoutSerialNumb() {
        CarDTO car = CarDTO.builder()
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
        System.out.println(response.print());
        ErrorMessageDtoString errorMessageDtoString = response.getBody().as(ErrorMessageDtoString.class);
        softAssert.assertEquals(response.getStatusCode(), 400);
        softAssert.assertEquals(response.getStatusCode(), 400, "validate status code");
        softAssert.assertTrue(response.getBody().print().contains("serialNumber"));
        softAssert.assertTrue(errorMessageDtoString.getError().equals("Bad Request"), "validate error");
        softAssert.assertAll();
    }

}
