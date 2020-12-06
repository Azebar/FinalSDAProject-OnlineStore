package ee.sda.finalprojectonlinestore.controllers;


import ee.sda.finalprojectonlinestore.entities.Product;
import ee.sda.finalprojectonlinestore.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin-panel")
@RequiredArgsConstructor
@Controller
public class ProductController {

    @Autowired
    final ProductService productService;

    @GetMapping("/create-product")
    String createProduct() {
        return "create-product";
    }

    @PostMapping("/create-product")
    String createProduct(@ModelAttribute Product product, Model model) {
        model.addAttribute("category", productService.save(product));
        return "redirect:/create-product";
    }
}
