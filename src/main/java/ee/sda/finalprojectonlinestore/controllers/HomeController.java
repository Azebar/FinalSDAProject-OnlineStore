package ee.sda.finalprojectonlinestore.controllers;

import ee.sda.finalprojectonlinestore.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class HomeController {

    @Autowired
    final ProductService productService;

    @GetMapping("/index")
    String showProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "home";
    }
}
