package ee.sda.finalprojectonlinestore.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
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
