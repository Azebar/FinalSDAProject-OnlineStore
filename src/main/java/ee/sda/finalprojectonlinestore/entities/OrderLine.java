package ee.sda.finalprojectonlinestore.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderLine {

    @GeneratedValue
    @Id
    Long id;
    @OneToOne
    @JoinColumn(name = "product_id")
    Product product;
    Integer quantityOfProducts;
    @ManyToOne
    @JoinColumn(name = "order_id")
    Order order;

}
