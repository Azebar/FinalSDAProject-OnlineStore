package ee.sda.finalprojectonlinestore.entities;

import ee.sda.finalprojectonlinestore.enums.OrdersStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Orders {

    @GeneratedValue
    @Id
    Long id;
    String deliveryAddress;
    Date orderDate;
    @OneToMany(mappedBy = "orders")
    List<OrderLine> orderLines;
    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;
    @Enumerated
    OrdersStatus status;
}
