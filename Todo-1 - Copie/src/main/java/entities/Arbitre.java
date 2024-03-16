package entities;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data @Entity
public class Arbitre {
    @Id
    private Long idArbitre;
    private String nom;
    private String nationalite;

    @JsonIgnore
    @OneToMany(mappedBy = "arbitre")
    private List<Match> matches;
    
    // getters and setters
}
