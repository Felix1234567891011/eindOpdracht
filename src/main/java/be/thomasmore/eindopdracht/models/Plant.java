package be.thomasmore.eindopdracht.models;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Plant {
    private static int counter = 3;
    @Id
    private Integer id;
    private String name;
    private String description;
    private int deadlines;
    private String image;
    @ManyToMany(mappedBy = "plants")
    private Collection<Artikel> artikels;
    public Plant() {
        this.id = counter;
        counter++;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDeadlines() {
        return deadlines;
    }

    public void setDeadlines(int deadlines) {
        this.deadlines = deadlines;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }



    public Collection<Artikel> getArtikels() {
        return artikels;
    }

    public void setArtikels(Collection<Artikel> artikels) {
        this.artikels = artikels;
    }
}

