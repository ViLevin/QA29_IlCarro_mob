package rest;

import api_rest.CarController;
import dto.CarsDTO;
import dto.ErrorMessageDtoString;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DeleteCarTestRest extends CarController {
    CarsDTO cars;
    SoftAssert softAssert = new SoftAssert();

    @BeforeClass
    public void gerUserCarBeforeDelete() {
        Response response = getAllUserCars();
        if (response.getStatusCode() == 200) {
            cars = response.getBody().as(CarsDTO.class);
        } else
            System.out.println("status code NOT 200 --->" + response.getStatusCode());
    }

    @Test
    public void deleteCarPositiveTest() {
        if (cars.getCars().length != 0) {
            String serialNumber = cars.getCars()[0].getSerialNumber();
            Response response = deleteCarBySerialNumber(serialNumber);
            Assert.assertEquals(response.getStatusCode(), 200);
        } else
            Assert.fail("User don`t have cars");
    }

    @Test
    public void deleteCarNegativeTest_WrongSerialNumber() {
        Response response = deleteCarBySerialNumber("serialNumber");
        softAssert.assertEquals(response.getStatusCode(), 400, "validate status code");
        ErrorMessageDtoString errorMessageDtoString = response.getBody().as(ErrorMessageDtoString.class);
        System.out.println(errorMessageDtoString);
        softAssert.assertEquals(errorMessageDtoString.getMessage(), "Car with serial number serialNumber not found");
        softAssert.assertAll();
    }


}
