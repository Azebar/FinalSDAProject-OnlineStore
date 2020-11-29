package ee.sda.finalprojectonlinestore.repositories;

import ee.sda.finalprojectonlinestore.entities.OrderLine;
import org.springframework.data.repository.CrudRepository;

public interface OrderLineRepository extends CrudRepository<OrderLine, Long> {
}
