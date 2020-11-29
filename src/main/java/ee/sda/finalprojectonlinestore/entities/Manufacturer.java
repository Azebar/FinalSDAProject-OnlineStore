package ee.sda.finalprojectonlinestore.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Setter
@Getter
public class Manufacturer {

    @GeneratedValue
    @Id
    Long id;
    String name;
    @OneToMany(mappedBy = "product")
    List<Product> products;
}
