package be.thomasmore.eindopdracht.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class Artikel {
    @Id
    private Integer id;
    private String titel;
    private String onderwerp;
    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Plant> plants;

    public Artikel() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getOnderwerp() {
        return onderwerp;
    }

    public void setOnderwerp(String onderwerp) {
        this.onderwerp = onderwerp;
    }

    public Collection<Plant> getPlants() {
        return plants;
    }

    public void setPlants(Collection<Plant> plants) {
        this.plants = plants;
    }
}
