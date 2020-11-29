package ee.sda.finalprojectonlinestore.entities;

import ee.sda.finalprojectonlinestore.enums.OrderStatus;
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
public class Order {

    @GeneratedValue
    @Id
    Long id;
    String deliveryAddress;
    Date dateOfOrder;
    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
    List<OrderLine> orderLines;
    @OneToOne
    @JoinColumn(name = "user_id")
    User user;
    @Enumerated
    OrderStatus status;
}
