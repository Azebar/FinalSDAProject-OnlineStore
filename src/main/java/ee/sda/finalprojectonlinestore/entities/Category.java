package ee.sda.finalprojectonlinestore.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
public class Category {

    @GeneratedValue
    @Id
    Long id;
    String name;
    @ManyToOne
    Category parent;
    @OneToMany(mappedBy = "parent", orphanRemoval = true)
    List<Category> parents;
    @OneToMany(mappedBy = "category")
    List<Product> products;
}
