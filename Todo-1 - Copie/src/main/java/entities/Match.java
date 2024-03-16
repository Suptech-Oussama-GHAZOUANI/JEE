package entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data @Entity
public class Match {
    @Id
    private Long idMatch;
    private LocalDate dateMatch;
    private LocalTime heureMatch;

    @JsonIgnore
    @ManyToOne
    private Arbitre arbitre;

    @ManyToOne
    private Stade stade;

    @ManyToMany
    private List<Equipe> equipes;
    
    // getters and setters
}
