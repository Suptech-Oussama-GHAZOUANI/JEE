package jee.suptech.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data @Entity @Table(name = "matches")
public class Match {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idMatch;
    LocalDate dateMatch;
    LocalTime heureMatch;

    @JsonIgnore
    @ManyToOne
    Arbitre arbitre;

    @ManyToOne
    Stade stade;
    
    @ManyToOne
    Equipe equipe1;
    
    @ManyToOne
    Equipe equipe2;
    
    // getters and setters
}
