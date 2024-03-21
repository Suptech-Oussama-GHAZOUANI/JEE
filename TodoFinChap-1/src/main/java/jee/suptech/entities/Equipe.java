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
public class Equipe {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long idEquipe;
    private String nomEquipe;
    private String pays;

    @JsonIgnore
    @OneToMany(mappedBy = "equipe")
    private List<Joueur> joueurs;
    
    
    @JsonIgnore
    @OneToMany(mappedBy = "equipe1")
    private List<Match> matchEquipe1;
    
    
    @JsonIgnore
    @OneToMany(mappedBy = "equipe2")
    private List<Match> matchEquipe2;

    
    // getters and setters
}
