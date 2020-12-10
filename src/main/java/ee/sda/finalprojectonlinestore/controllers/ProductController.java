package ee.sda.finalprojectonlinestore.controllers;


import ee.sda.finalprojectonlinestore.entities.Category;
import ee.sda.finalprojectonlinestore.entities.Product;
import ee.sda.finalprojectonlinestore.services.CategoryService;
import ee.sda.finalprojectonlinestore.services.ManufacturerService;
import ee.sda.finalprojectonlinestore.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/admin-panel")
@RequiredArgsConstructor
@Controller
public class ProductController {

    @Autowired
    final ProductService productService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    ManufacturerService manufacturerService;

    @GetMapping("/create-product")
    String createProduct(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryService.getAllCategoriesWithoutParents());
        model.addAttribute("manufacturers", manufacturerService.getAllManufacturers());
        model.addAttribute("products", productService.getAllProducts());
        return "create-product";
    }

    @GetMapping("/create-product/{categoryId}")
    String getCategoriesById(Model model, @PathVariable String categoryId) {
        model.addAttribute("resultCategories", categoryService.getAllCategoriesFromParent(categoryId));
        return "create-product :: category";
    }

    @GetMapping("/edit-product/{productId}/{categoryId}")
    String editCategoriesById(Model model, @PathVariable String categoryId) {
        model.addAttribute("resultCategories", categoryService.getAllCategoriesFromParent(categoryId));
        return "edit-product :: category";
    }

    @PostMapping("/save-product")
    ModelAndView saveProduct(@ModelAttribute Product product, Model model) {
        model.addAttribute("product", productService.save(product));
        return new ModelAndView("redirect:/admin-panel/create-product");
    }

    @GetMapping("/edit-product/{productId}")
    String editProduct(@PathVariable String productId, Model model) {
        model.addAttribute(productService.getProductById(productId));
        model.addAttribute("categories", categoryService.getAllCategoriesWithoutParents());
        model.addAttribute("manufacturers", manufacturerService.getAllManufacturers());
        return "edit-product";
    }

    @GetMapping("/delete-product/{productId}")
    ModelAndView deleteProduct(@PathVariable String productId) {
        productService.deleteProduct(productId);
        return new ModelAndView("redirect:/admin-panel/create-product");
    }
}
