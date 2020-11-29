package ee.sda.finalprojectonlinestore.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class OrderLine {

    @Id
    @GeneratedValue
    Long id;
    @OneToOne
    @JoinColumn(name = "product_id")
    Product product;
    Integer quantityOfProducts;
    @ManyToOne
    @JoinColumn(name = "order_id")
    Order order;
}
