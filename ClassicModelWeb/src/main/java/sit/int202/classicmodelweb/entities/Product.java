package sit.int202.classicmodelweb.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@Table(name = "products", indexes = {
        @Index(name = "productLine", columnList = "productLine")
})
@Entity
@NamedQueries({
        @NamedQuery(name = "Product.findAll", query = "select p from Product p"),
        @NamedQuery(name = "Product.count", query = "select count(p) from Product p")
})
public class Product {
    @Id
    @Column(name = "productCode", nullable = false, length = 15)
    private String id;

    @Column(name = "productName", nullable = false, length = 70)
    private String productName;

    @ManyToOne(optional = false)
    @JoinColumn(name = "productLine", nullable = false)
    private Productline productLine;

    @Column(name = "productScale", nullable = false, length = 10)
    private String productScale;

    @Column(name = "productVendor", nullable = false, length = 50)
    private String productVendor;

    @Lob
    @Column(name = "productDescription", nullable = false)
    private String productDescription;

    @Column(name = "quantityInStock", nullable = false)
    private Integer quantityInStock;

    @Column(name = "buyPrice", nullable = false, precision = 10, scale = 2)
    private BigDecimal buyPrice;

    @Column(name = "MSRP", nullable = false, precision = 10, scale = 2)
    private BigDecimal msrp;
}