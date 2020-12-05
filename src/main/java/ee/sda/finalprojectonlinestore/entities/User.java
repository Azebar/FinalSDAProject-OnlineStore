package ee.sda.finalprojectonlinestore.entities;

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
public class User {

    @GeneratedValue
    @Id
    Long id;
    String username;
    String firstName;
    String lastName;
    String password;
    String address;
    Date created;
    String preferredMessagingChannel;
    @OneToMany(mappedBy = "user")
    List<Orders> ordersList;
    @ManyToMany(mappedBy = "users", fetch = FetchType.EAGER)
    List<Role> roles;

}
