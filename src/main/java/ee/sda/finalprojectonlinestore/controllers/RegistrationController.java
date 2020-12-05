package ee.sda.finalprojectonlinestore.controllers;

import ee.sda.finalprojectonlinestore.entities.User;
import ee.sda.finalprojectonlinestore.services.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class RegistrationController {

    @Autowired
    final RegisterService registerService;

    @GetMapping("/register")
    String register() {
        return "register";
    }

    @PostMapping("/register")
    String createUser(@ModelAttribute User user, Model model) {
        model.addAttribute("user", registerService.createUser(user));
        return "login";
    }
}
