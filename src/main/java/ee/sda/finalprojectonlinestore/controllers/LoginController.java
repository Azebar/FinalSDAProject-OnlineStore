package ee.sda.finalprojectonlinestore.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
@Controller
public class LoginController {

    @GetMapping("/login")
    String login(HttpServletRequest request) {
        return redirectToPanel(request, false);
    }

    @GetMapping("/")
    String loginHome(HttpServletRequest request) {
        return redirectToPanel(request, true);
    }

    String redirectToPanel(HttpServletRequest request, boolean home) {
        if (request.isUserInRole("ROLE_ADMIN")) {
            return "redirect:/admin-panel";
        }
        if (request.isUserInRole("ROLE_USER")) {
            return "redirect:/user-panel";
        }
        return home ? "home" : "login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        new SecurityContextLogoutHandler().logout(request, response, authentication);
        return "redirect:/login";
    }
}