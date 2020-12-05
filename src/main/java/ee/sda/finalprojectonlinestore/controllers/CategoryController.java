package ee.sda.finalprojectonlinestore.controllers;

import ee.sda.finalprojectonlinestore.entities.Category;
import ee.sda.finalprojectonlinestore.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class CategoryController {

    @Autowired
    final CategoryService categoryService;

    @GetMapping("/create-category")
    String createCategory() {
        return "create-category";
    }

    @PostMapping("/create-category")
    String createCategory(@ModelAttribute Category category, Model model) {
        model.addAttribute("category", categoryService.save(category));
        return "redirect:/create-category";
    }
}
