package ee.sda.finalprojectonlinestore.controllers;

import ee.sda.finalprojectonlinestore.entities.Role;
import ee.sda.finalprojectonlinestore.services.RoleService;
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
public class RoleController {

    @Autowired
    final RoleService roleService;

    @GetMapping("/create-role")
    String createRole() {
        return "create-role";
    }

    @PostMapping("/create-role")
    String createRole(@ModelAttribute Role role, Model model) {
        model.addAttribute("user", roleService.save(role));
        return "redirect:/admin-panel";
    }
}
