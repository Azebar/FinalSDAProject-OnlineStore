package ee.sda.finalprojectonlinestore.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class AdminPanelController {

    @GetMapping("/admin-panel")
    String adminPanel() {
        return "admin-panel";
    }
}
