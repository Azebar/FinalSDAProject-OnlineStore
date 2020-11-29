package ee.sda.finalprojectonlinestore.entities;

import ee.sda.finalprojectonlinestore.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @GeneratedValue
    @Id
    Long id;
    String login;
    String firsName;
    String lastName;
    String password;
    String address;
    @ManyToMany(mappedBy = "users", fetch = FetchType.EAGER)
    List<Role> roles;
    String preferredMessagingChannel;
    @OneToOne(mappedBy = "user")
    Order order;
}
