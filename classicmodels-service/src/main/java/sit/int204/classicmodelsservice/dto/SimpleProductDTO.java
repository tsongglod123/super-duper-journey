package sit.int204.classicmodelsservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import sit.int204.classicmodelsservice.entities.Productline;

@Getter
@Setter
public class SimpleProductDTO {
    private String id;
    private String productName;
    @JsonIgnore
    private Productline productLine;
    private Double msrp;

    public String getProductLine() {
        return productLine.getId();
    }

    public String getImageUrl() {
        return id + ".jpg";
    }
}
