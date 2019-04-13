package hr.java.web.pavlovic.moneyapp.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping({" ","/"})
    public String showHome(Model model){
        return "index";
    }

    @GetMapping("login")
    public String login(Model model){
        return "login";
    }
    @GetMapping("/about")
    public String showAbout(Model model){
        return "about";
    }
}
