package ee.sda.finalprojectonlinestore.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Setter
@Getter
public class Category {

    @GeneratedValue
    @Id
    Long id;
    String name;
    @OneToOne(mappedBy = "category")
    Product product;
}
