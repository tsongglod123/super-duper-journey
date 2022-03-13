package sit.int204.classicmodelsservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SimpleCustomerDTO {
    private String customerName;
    private String phone;
    private String city;
    private String country;
    @JsonIgnore
    private SimpleEmployeeDTO salesRepEmployee;

    public String getSalesPerson() {
        return salesRepEmployee == null ? "-" : salesRepEmployee.getName();
    }
}
