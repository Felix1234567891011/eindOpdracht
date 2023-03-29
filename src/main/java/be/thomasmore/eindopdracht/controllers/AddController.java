package be.thomasmore.eindopdracht.controllers;

import be.thomasmore.eindopdracht.models.Plant;
import be.thomasmore.eindopdracht.repositories.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class AddController {
    @Autowired
    private PlantRepository plantRepository;

    @GetMapping("/add")
    public String addPlant(Model model) {
        model.addAttribute("plant", new Plant());
        return "add";
    }

    @PostMapping("/add")
    public String savePlant(@ModelAttribute("plant") Plant plant,
                            @RequestParam("file") MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            String fileName = file.getOriginalFilename();
            String uploadDir = "C:/Users/felix/Documents/Programmeren/Advanced Programming Techniques/eindOpdracht/eindOpdracht/src/main/resources/static/images/";
            String filePath = uploadDir + fileName;
            File dest = new File(filePath);
            file.transferTo(dest);
            plant.setImage(fileName);
        }

        plantRepository.save(plant);

        return "redirect:/";
    }


}
