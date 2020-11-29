package ee.sda.finalprojectonlinestore.repositories;

import ee.sda.finalprojectonlinestore.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository  extends CrudRepository<Category, Long> {
}
