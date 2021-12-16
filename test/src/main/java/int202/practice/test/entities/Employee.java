package int202.practice.test.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Table(name = "employees", indexes = {
        @Index(name = "officeCode", columnList = "officeCode"),
        @Index(name = "reportsTo", columnList = "reportsTo")
})
@Entity
@Getter
@Setter
@ToString
public class Employee {
    @Id
    @Column(name = "employeeNumber", nullable = false)
    private Integer id;

    @Column(name = "lastName", nullable = false, length = 50)
    private String lastName;

    @Column(name = "firstName", nullable = false, length = 50)
    private String firstName;

    @Column(name = "extension", nullable = false, length = 10)
    private String extension;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @ManyToOne(optional = false)
    @JoinColumn(name = "officeCode", nullable = false)
    private Office officeCode;

    @ManyToOne
    @JoinColumn(name = "reportsTo")
    private Employee reportsTo;

    @Column(name = "jobTitle", nullable = false, length = 50)
    private String jobTitle;
}