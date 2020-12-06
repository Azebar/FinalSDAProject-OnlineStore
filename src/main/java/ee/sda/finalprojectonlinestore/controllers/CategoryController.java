package ee.sda.finalprojectonlinestore.controllers;

import ee.sda.finalprojectonlinestore.entities.Category;
import ee.sda.finalprojectonlinestore.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/admin-panel")
@RequiredArgsConstructor
@Controller
public class CategoryController {

    @Autowired
    final CategoryService categoryService;

    @GetMapping("/create-category")
    String createCategory(Model model) {
        model.addAttribute("categories", categoryService.getAllCategoriesWithoutParents());
        return "create-category";
    }

    @PostMapping("/save-category")
    ModelAndView saveCategory(@ModelAttribute Category category) {
        categoryService.save(category);
        return new ModelAndView("redirect:/admin-panel/create-category");
    }

    @GetMapping("/edit-category/{categoryId}")
    String editCategory(@PathVariable String categoryId, Model model) {
        model.addAttribute(categoryService.getCategoryById(categoryId));
        return "edit-category";
    }

    @GetMapping("/edit-subcategory/{categoryId}")
    String editSubCategory(@PathVariable String categoryId, Model model) {
        model.addAttribute(categoryService.getCategoryById(categoryId));
        return "edit-subcategory";
    }

    @GetMapping("/delete-category/{categoryId}")
    ModelAndView deleteCategory(@PathVariable String categoryId) {
        categoryService.deleteCategory(categoryId);
        return new ModelAndView("redirect:/admin-panel/create-category");
    }

    @GetMapping("/delete-subcategory/{categoryId}")
    ModelAndView deleteSubCategory(@PathVariable String categoryId) {
        Long id = categoryService.getCategoryById(categoryId).getParent().getId();
        categoryService.deleteCategory(categoryId);
        return new ModelAndView("redirect:/admin-panel/add-subcategory/" + id);
    }

    @GetMapping("/add-subcategory/{categoryId}")
    String addSubCategory(@PathVariable String categoryId, Model model) {
        model.addAttribute(categoryService.getCategoryById(categoryId));
        model.addAttribute("categoriesFromParent", categoryService.getAllCategoriesFromParent(categoryId));
        return "add-subcategory";
    }

    @PostMapping("/save-subcategory/{categoryId}")
    ModelAndView saveSubCategory(@PathVariable String categoryId, @ModelAttribute Category category) {
        categoryService.addSubCategory(category,categoryId);
        return new ModelAndView("redirect:/admin-panel/add-subcategory/{categoryId}");
    }
}
