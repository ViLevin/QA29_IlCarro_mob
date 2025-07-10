package dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString


public class CarsDTO {
    CarDTO[] cars;
}
