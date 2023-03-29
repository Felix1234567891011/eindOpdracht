package be.thomasmore.eindopdracht.repositories;

import be.thomasmore.eindopdracht.models.Plant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PlantRepository extends CrudRepository<Plant, Integer> {
    List<Plant> findAll();

    Optional<Plant> findById(int id);
    @Query("SELECT p FROM Plant p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :search, '%'))")
    List<Plant> findByNameContainingIgnoreCase(@Param("search") String search);
    List<Plant> findAllBy();
}
