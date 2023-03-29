package be.thomasmore.eindopdracht.controllers;

import be.thomasmore.eindopdracht.models.Plant;
import be.thomasmore.eindopdracht.repositories.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;
import java.util.UUID;

@Controller
public class DetailController {
    @Autowired
    private PlantRepository plantRepository;

    @GetMapping("/plantdetails/{id}")
        public String details (Model model, @PathVariable(required = false) int id) {
            if (id == 0) {
                return "details";
            }
            Optional<Plant> plantFromDb = plantRepository.findById(id);
            if (plantFromDb.isPresent()) {
                model.addAttribute("plant", plantFromDb.get());
            }
        return "details";
    }
}
