package dto;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class CarDTO {

    private String serialNumber;
    private String manufacture;
    private String model;
    private String year;
    private String fuel;
    private int seats;
    private String carClass;
    private Double pricePerDay;
    private String about;
    private String city;

    @Override

    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CarDTO carDTO = (CarDTO) o;
        return seats == carDTO.seats && Objects.equals(serialNumber, carDTO.serialNumber) && Objects.equals(manufacture, carDTO.manufacture) && Objects.equals(model, carDTO.model) && Objects.equals(year, carDTO.year) && Objects.equals(fuel, carDTO.fuel) && Objects.equals(carClass, carDTO.carClass) && Objects.equals(pricePerDay, carDTO.pricePerDay) && Objects.equals(about, carDTO.about) && Objects.equals(city, carDTO.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serialNumber, manufacture, model, year, fuel, seats, carClass, pricePerDay, about, city);
    }
}
