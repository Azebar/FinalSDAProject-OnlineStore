package ee.sda.finalprojectonlinestore.entities;

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
    @ManyToOne
    @JoinColumn(name = "category_id")
    Category category;
    Integer price;
    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    Manufacturer manufacturer;
}
