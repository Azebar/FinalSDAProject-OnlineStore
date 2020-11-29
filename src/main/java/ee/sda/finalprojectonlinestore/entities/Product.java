package ee.sda.finalprojectonlinestore.entities;

import ee.sda.finalprojectonlinestore.enums.ProductType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class Product {

    @GeneratedValue
    @Id
    Long id;
    String title;
    String description;
    String thumbnail;
    @OneToOne
    @JoinColumn(name = "category_id")
    Category category;
    Integer price;
    @Enumerated
    ProductType productType;
    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    Manufacturer manufacturer;
    @OneToOne(mappedBy = "product")
    OrderLine orderLine;

}
