package hr.java.web.pavlovic.moneyapp.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @GetMapping({" ","/"})
    public String showHome(Model model){
        return "index";
    }

    @GetMapping("/about")
    public String showAbout(Model model){
        return "about";
    }
}
