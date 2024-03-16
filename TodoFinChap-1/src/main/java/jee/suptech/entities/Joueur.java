package jee.suptech.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data @Entity
public class Joueur {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idJoueur;
    private String nomJoueur;
    private String poste;

    @JsonIgnore
    @ManyToOne
    private Equipe equipe;
    
    // getters and setters
}