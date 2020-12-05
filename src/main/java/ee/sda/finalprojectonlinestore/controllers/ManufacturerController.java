package ee.sda.finalprojectonlinestore.controllers;

import ee.sda.finalprojectonlinestore.entities.Manufacturer;
import ee.sda.finalprojectonlinestore.entities.Product;
import ee.sda.finalprojectonlinestore.services.ManufacturerService;
import ee.sda.finalprojectonlinestore.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class ManufacturerController {

    @Autowired
    final ManufacturerService manufacturerService;

    @GetMapping("/create-manufacturer")
    String createManufacturer() {
        return "create-manufacturer";
    }

    @PostMapping("/create-manufacturer")
    String createManufacturer(@ModelAttribute Manufacturer manufacturer, Model model) {
        model.addAttribute("manufacturer", manufacturerService.save(manufacturer));
        return "redirect:/create-manufacturer";
    }
}