package ee.sda.finalprojectonlinestore.repositories;

import ee.sda.finalprojectonlinestore.entities.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
