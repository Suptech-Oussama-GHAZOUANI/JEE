package jee.suptech.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jee.suptech.entities.Joueur;

@Repository
public interface JoueurRepository extends JpaRepository<Joueur, Long> {
    List<Joueur> findByEquipeNomEquipeAndPoste(String nomEquipe, String poste);
}
