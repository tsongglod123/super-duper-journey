package sit.int204.classicmodelsservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SimpleEmployeeDTO {
    private String lastName;
    private String firstName;

    public String getName() {
        return firstName + " " + lastName;
    }
}
