package ee.sda.finalprojectonlinestore.controllers;

import ee.sda.finalprojectonlinestore.entities.Category;
import ee.sda.finalprojectonlinestore.entities.Manufacturer;
import ee.sda.finalprojectonlinestore.entities.Product;
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
public class ManufacturerController {

    @Autowired
    final ManufacturerService manufacturerService;

    @GetMapping("/create-manufacturer")
    String createManufacturer(Model model) {
        model.addAttribute("manufacturers", manufacturerService.getAllManufacturers());
        return "create-manufacturer";
    }

    @PostMapping("/save-manufacturer")
    ModelAndView saveManufacturer(@ModelAttribute Manufacturer manufacturer) {
        manufacturerService.save(manufacturer);
        return new ModelAndView("redirect:/admin-panel/create-manufacturer");
    }

    @GetMapping("/edit-manufacturer/{manufacturerId}")
    String editManufacturer(@PathVariable String manufacturerId, Model model) {
        model.addAttribute(manufacturerService.getManufacturerById(manufacturerId));
        return "edit-manufacturer";
    }

    @GetMapping("/delete-manufacturer/{manufacturerId}")
    ModelAndView deleteManufacturer(@PathVariable String manufacturerId) {
        manufacturerService.deleteManufacturer(manufacturerId);
        return new ModelAndView("redirect:/admin-panel/create-manufacturer");
    }
}