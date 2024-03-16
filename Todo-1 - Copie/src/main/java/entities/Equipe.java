package entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data @Entity
public class Equipe {
    @Id
    private Long idEquipe;
    private String nomEquipe;
    private String pays;

    @JsonIgnore
    @OneToMany(mappedBy = "equipe")
    private List<Joueur> joueurs;

    @ManyToMany(mappedBy = "equipes")
    private List<Match> matches;
    
    // getters and setters
}
