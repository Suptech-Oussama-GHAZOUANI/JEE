package jee.suptech.controllers;


import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jee.suptech.entities.Equipe;
import jee.suptech.entities.Joueur;
import jee.suptech.repositories.EquipeRepository;
import jee.suptech.repositories.JoueurRepository;

@RestController
@RequestMapping("todo2")

public class JoueurController {
	@Autowired  
	private JoueurRepository joueurRepository;
	@Autowired  
	private EquipeRepository equipeRepository;
	
	@PostMapping ("joueur/equipe/{idequipe}")
	public Joueur addJoueurByIdEquipe(@PathVariable("idequipe") Long idequipe, @RequestBody Joueur joueur) {
	    Optional<Equipe> equipe = equipeRepository.findById(idequipe);
	    if (equipe.isPresent()) {
	        joueur.setEquipe(equipe.get());
	        return joueurRepository.save(joueur);
	    }
	    return null;
	}

   
	@GetMapping("joueurs")
	   private List<Joueur> getJoueurs (@RequestBody Equipe equipe){
		 return joueurRepository.findAll();
	   }

	@GetMapping("joueurs/equipe/{nomEquipe}")
	public List<Joueur> getJoueursByEquipe(@PathVariable("nomEquipe") String nomEquipe) {
	    Optional<Equipe> equipe = equipeRepository.findByNomEquipe(nomEquipe);
	    if (equipe.isPresent()) {
	        return joueurRepository.findByEquipe(equipe.get());
	    }
	    return null;
	}
	
	@GetMapping("joueurs/equipe/{nomEquipe}/poste/{poste}")
	public List<Joueur> getJoueursByEquipeAndPoste(@PathVariable("nomEquipe") String nomEquipe, @PathVariable("poste") String poste) {
	    return joueurRepository.findByEquipeNomEquipeAndPoste(nomEquipe, poste);
	}
   
    @PutMapping("joueur/{id}")
    public Joueur updateMatch(@PathVariable Long id, @RequestBody Joueur newJoueur) {
        return joueurRepository.findById(id)
                .map(joueur -> {
                	joueur.setNomJoueur(newJoueur.getNomJoueur());
                	joueur.setPoste(newJoueur.getPoste());
                    return joueurRepository.save(joueur);
                })
                .orElseGet(() -> {
                	newJoueur.setIdJoueur(id);
                    return joueurRepository.save(newJoueur);
                });
    }
    
    @DeleteMapping("joueur/{id}")
    public void deleteMatch(@PathVariable Long id) {
    	joueurRepository.deleteById(id);
    }
}
   