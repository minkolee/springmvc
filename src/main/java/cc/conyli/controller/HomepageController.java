package cc.conyli.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomepageController {

    @RequestMapping("/")
    public String Homepage() {
        return "home";
    }

    @RequestMapping("/leader")
    public String showManagerpage() {
        return "manager";
    }

    @RequestMapping("/system")
    public String showAdminPage() {
        return "system";
    }

    @RequestMapping("/access-denied/")
    public String accessDenied() {
        return "denied";
    }
}
