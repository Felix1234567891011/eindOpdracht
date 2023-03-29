package be.thomasmore.eindopdracht.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArtikelController {
    @GetMapping("/artikel")
    public String artikel() {
        return "artikel";
    }
}
