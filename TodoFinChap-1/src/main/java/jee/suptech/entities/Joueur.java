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
    Long idJoueur;
    String nomJoueur;
    String poste;

    @JsonIgnore
    @ManyToOne
    Equipe equipe;
    
    // getters and setters
}