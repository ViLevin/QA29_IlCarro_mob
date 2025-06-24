package dto;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor


public class RegistrationBodyDTO {
    private String username;
    private String password;
    private String firstname;
    private String lastname;

}
