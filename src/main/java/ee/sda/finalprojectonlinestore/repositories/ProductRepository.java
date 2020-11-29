package ee.sda.finalprojectonlinestore.repositories;

import ee.sda.finalprojectonlinestore.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
