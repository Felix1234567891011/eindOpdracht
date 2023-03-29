package be.thomasmore.eindopdracht.controllers;

import be.thomasmore.eindopdracht.models.Plant;
import be.thomasmore.eindopdracht.repositories.PlantRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {
    private Logger logger = LoggerFactory.getLogger(HomeController.class);
    @Autowired
    private PlantRepository plantRepository;

    @GetMapping("/")
    public String home(Model model, @RequestParam(required = false) String title) {
        logger.info(String.format("artistListWithFilter -- title=%s", title));
        Iterable<Plant> allPlants = plantRepository.findAll();
        if (title != null && !title.isEmpty()) {
            allPlants = plantRepository.findByNameContainingIgnoreCase(title);
        } else {
            allPlants = plantRepository.findAllBy();
        }
        model.addAttribute("plants", allPlants);
        return "home";
    }

    @GetMapping("/delete")
    public String delete(Model model) {
        Iterable<Plant> allPlants = plantRepository.findAll();
        model.addAttribute("plants", allPlants);
        model.addAttribute("delete", true);
        return "home";
    }

    @PostMapping("/delete")
    public String deletePlant(@RequestParam("id") int id) {
        Optional<Plant> plant = plantRepository.findById(id);
        if (plant.isPresent()) {
            plantRepository.delete(plant.get());
        }
        return "redirect:/delete";
    }
}
