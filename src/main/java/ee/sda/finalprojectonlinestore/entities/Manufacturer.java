package ee.sda.finalprojectonlinestore.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
public class Manufacturer {

    @GeneratedValue
    @Id
    Long id;
    String name;
    @OneToMany(mappedBy = "manufacturer")
    List<Product> products;
}
