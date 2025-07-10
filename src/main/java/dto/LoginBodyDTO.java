package dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class LoginBodyDTO {
    private String username;
    private String password;

}
