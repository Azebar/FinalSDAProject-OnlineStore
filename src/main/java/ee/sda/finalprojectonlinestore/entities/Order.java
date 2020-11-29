package ee.sda.finalprojectonlinestore.entities;

import ee.sda.finalprojectonlinestore.enums.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue
    Long id;
    Integer totalCost;
    String deliveryAddress;
    Date dateOfOrder;
    @OneToMany(mappedBy = "order")
    List<OrderLine> orderLines;
    @OneToOne
    @JoinColumn(name = "user_id")
    User user;
    @Enumerated
    OrderStatus status;
}
