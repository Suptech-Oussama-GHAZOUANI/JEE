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
    
    Long idEquipe;
    String nomEquipe;
    String pays;

    @JsonIgnore
    @OneToMany(mappedBy = "equipe")
    List<Joueur> joueurs;
    
    
    @JsonIgnore
    @OneToMany(mappedBy = "equipe1")
    List<Match> matchEquipe1;
    
    
    @JsonIgnore
    @OneToMany(mappedBy = "equipe2")
    List<Match> matchEquipe2;

    
    // getters and setters
}
