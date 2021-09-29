package sit.int202.classicmodelweb.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "offices")
@Getter
@Setter
public class Office {
    @Id
    private String officeCode;
    private String city;
    private String postalCode;
    private String country;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Office {");
        sb.append("officeCode = '").append(officeCode).append('\'');
        sb.append(", city = '").append(city).append('\'');
        sb.append(", postalCode = '").append(postalCode).append('\'');
        sb.append(", country = '").append(country).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
