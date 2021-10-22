package sit.int202.classicmodelweb.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter

@NamedQueries({
        @NamedQuery(name = "Office.findAll", query = "select o from Office o"),
        @NamedQuery(name = "Office.findByCountry", query = "select o from Office o where o.country like :countryName")
})

@Table(name = "offices")
@Entity
@ToString
public class Office {
    @Id
    @Column(name = "officeCode", nullable = false, length = 10)
    private String id;

    @Column(name = "city", nullable = false, length = 50)
    private String city;

    @Column(name = "phone", nullable = false, length = 50)
    private String phone;

    @Column(name = "addressLine1", nullable = false, length = 50)
    private String addressLine1;

    @Column(name = "addressLine2", length = 50)
    private String addressLine2;

    @Column(name = "state", length = 50)
    private String state;

    @Column(name = "country", nullable = false, length = 50)
    private String country;

    @Column(name = "postalCode", nullable = false, length = 15)
    private String postalCode;

    @Column(name = "territory", nullable = false, length = 10)
    private String territory;

    @OneToMany(mappedBy = "officeCode", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Employee> employeeList;
}