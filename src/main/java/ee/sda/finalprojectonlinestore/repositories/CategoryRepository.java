package ee.sda.finalprojectonlinestore.repositories;

import ee.sda.finalprojectonlinestore.entities.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository  extends CrudRepository<Category, Long> {
    List<Category> findByParentId(Long id);
    List<Category> findByParentIsNull();
}
