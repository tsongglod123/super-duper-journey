package sit.int204.finalpractice.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeDto {
    private Integer id;
    private String lastName;
    private String firstName;
    private String email;
}
