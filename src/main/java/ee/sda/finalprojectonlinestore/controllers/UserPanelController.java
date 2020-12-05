package ee.sda.finalprojectonlinestore.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class UserPanelController {

    @GetMapping("/user-panel")
    String userPanel() {
        return "user-panel";
    }
}
