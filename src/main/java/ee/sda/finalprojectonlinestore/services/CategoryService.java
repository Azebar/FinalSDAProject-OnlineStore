package ee.sda.finalprojectonlinestore.services;

import ee.sda.finalprojectonlinestore.entities.Category;
import ee.sda.finalprojectonlinestore.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    final CategoryRepository categoryRepository;

    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> getAllCategories() {
        List<Category> categoryList = new ArrayList<>();
        categoryRepository.findAll().forEach(categoryList::add);
        return categoryList;
    }

    public Category getCategoryById(String id) {
        return categoryRepository.findById(Long.valueOf(id)).get();
    }

    public void deleteCategory(String id) {
        categoryRepository.deleteById(Long.valueOf(id));
    }

    public Category addSubCategory(Category category, String id) {
        category.setParent((getCategoryById(id)));
        categoryRepository.save(category);
        return category;
    }

    public List<Category> getAllCategoriesFromParent(String id) {
        List<Category> categoriesFromParent = new ArrayList<>();
        categoryRepository.findByParentId(Long.valueOf(id)).forEach(categoriesFromParent::add);
        return categoriesFromParent;
    }

    public List<Category> getAllCategoriesWithoutParents() {
        List<Category> categoryList = new ArrayList<>();
        categoryRepository.findByParentIsNull().forEach(categoryList::add);
        return categoryList;
    }
}
