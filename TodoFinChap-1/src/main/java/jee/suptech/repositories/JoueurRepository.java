package jee.suptech.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jee.suptech.entities.Equipe;
import jee.suptech.entities.Joueur;

@Repository
public interface JoueurRepository extends JpaRepository<Joueur, Long> {
	
	public List<Joueur> findByEquipeNomEquipeAndPoste(String nomEquipe, String poste);
	public List<Joueur> findByNomJoueur(String nomJoueur);
	public List<Joueur> findByPoste(String poste);
	public List<Joueur> findByEquipe(Equipe equipe);

}
