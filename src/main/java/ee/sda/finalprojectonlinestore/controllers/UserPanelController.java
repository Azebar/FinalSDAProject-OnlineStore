package ee.sda.finalprojectonlinestore.controllers;

import ee.sda.finalprojectonlinestore.configurations.OnlineStoreUserDetails;
import ee.sda.finalprojectonlinestore.entities.User;
import ee.sda.finalprojectonlinestore.services.OnlineStoreUserDetailsService;
import ee.sda.finalprojectonlinestore.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@Controller
public class UserPanelController {

    @Autowired
    UserService userService;
    @Autowired
    OnlineStoreUserDetailsService onlineStoreUserDetailsService;
    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/user-panel")
    String userPanel(Model model) {
        return "user-panel";
    }

    @GetMapping("/user-panel/show-user")
    String showUser(Model model) {
        model.addAttribute("user", userService.getCurrentUser());
        return "show-user";
    }

    @GetMapping("/user-panel/edit-user/")
    String editUser(Model model) {
        model.addAttribute(userService.getCurrentUser());
        return "edit-user";
    }

    @PostMapping("user-panel/save")
    ModelAndView saveEditedUser(@ModelAttribute User user) {
        userService.save(user);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        OnlineStoreUserDetails userDetails = (OnlineStoreUserDetails) authentication.getPrincipal();
        userDetails.setUsername(user.getUsername());
        return new ModelAndView("redirect:/user-panel/show-user");
    }

    @GetMapping("/user-panel/change-password/")
    String editPassword(Model model) {
        model.addAttribute(userService.getCurrentUser());
        return "change-password";
    }

    @PostMapping("/user-panel/change-password")
    public ModelAndView changeUserPassword(@ModelAttribute User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.save(user);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        OnlineStoreUserDetails userDetails = (OnlineStoreUserDetails) authentication.getPrincipal();
        userDetails.setPassword(user.getPassword());
        return new ModelAndView("redirect:/user-panel/show-user");
    }
}
