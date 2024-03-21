package jee.suptech.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data @Entity
public class Stade {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idStade;
    String nomStade;
    String ville;

    @JsonIgnore
    @OneToMany(mappedBy = "stade")
    List<Match> matches;
    
    // getters and setters
}

