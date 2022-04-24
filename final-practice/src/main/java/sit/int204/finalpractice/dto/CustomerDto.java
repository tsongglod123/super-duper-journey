package sit.int204.finalpractice.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerDto {
    private Integer id;
    private String customerName;
    private String contactLastName;
    private String contactFirstName;
    private String phone;
}
