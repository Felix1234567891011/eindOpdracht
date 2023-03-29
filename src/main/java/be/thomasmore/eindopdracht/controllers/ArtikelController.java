package be.thomasmore.eindopdracht.controllers;

import be.thomasmore.eindopdracht.models.Artikel;
import be.thomasmore.eindopdracht.models.Plant;
import be.thomasmore.eindopdracht.repositories.ArtikelRepository;
import be.thomasmore.eindopdracht.repositories.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class ArtikelController {
    @Autowired
    private ArtikelRepository artikelRepository;
    @GetMapping({"/artikel", "artikel/{id}"})
    public String artikel(Model model, @PathVariable(required = false) Integer id) {
        if (id == null) return "artikel";
        Optional<Artikel> optionalArtikel = artikelRepository.findById(id);
        if (optionalArtikel.isPresent()){
        model.addAttribute("artikels", optionalArtikel.get());}
        return "artikel";
    }
}
