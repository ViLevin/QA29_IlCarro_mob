package dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ErrorMessageDtoString {
    private String timestamp;
    private int status;
    private String error;
    private Object message;
    private String path;
}
