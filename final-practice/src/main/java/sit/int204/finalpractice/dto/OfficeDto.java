package sit.int204.finalpractice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OfficeDto {
    private String id;
    private String city;
    private String phone;
    private String state;
    private String country;
    private String postalCode;
}
