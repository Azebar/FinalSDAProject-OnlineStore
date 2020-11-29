package ee.sda.finalprojectonlinestore.controllers;


import ee.sda.finalprojectonlinestore.entities.Role;
import ee.sda.finalprojectonlinestore.entities.User;
import ee.sda.finalprojectonlinestore.services.RegisterService;
import ee.sda.finalprojectonlinestore.services.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
@Controller
public class LoginController {

    @Autowired
    final RegisterService registerService;
    final RoleService roleService;

    @GetMapping("/login")
    String login(Model model) {
        return "login";
    }

    @GetMapping("/register")
    String register() {
        return "register";
    }

    @PostMapping("/register")
    String createUser(@ModelAttribute User user, Model model) {
        model.addAttribute("user", registerService.createUser(user));
        return "login";
    }

    @GetMapping("/create-role")
    String createRole() {
        return "create-role";
    }

    @PostMapping("/create-role")
    String createRole(@ModelAttribute Role role, Model model) {
        model.addAttribute("user", roleService.save(role));
        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        new SecurityContextLogoutHandler().logout(request, response, authentication);
        return "redirect:/login";
    }
}