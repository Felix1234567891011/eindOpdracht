package be.thomasmore.eindopdracht.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "home";
    }
    @GetMapping("/details")
    public String details() {
        return "details";
    }
    @GetMapping("/add")
    public String add() {
        return "add";
    }
}
