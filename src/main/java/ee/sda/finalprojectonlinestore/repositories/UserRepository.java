package ee.sda.finalprojectonlinestore.repositories;

import ee.sda.finalprojectonlinestore.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
}
