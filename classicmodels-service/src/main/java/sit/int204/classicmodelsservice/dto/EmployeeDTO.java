package sit.int204.classicmodelsservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String extension;
    private String jobTitle;
    private String officeId;
}
