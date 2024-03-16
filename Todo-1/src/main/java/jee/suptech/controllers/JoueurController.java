package jee.suptech.controllers;


import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jee.suptech.entities.Equipe;
import jee.suptech.entities.Joueur;
import jee.suptech.repositories.EquipeRepository;
import jee.suptech.repositories.JoueurRepository;

@RestController
@RequestMapping("todo")

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
   
   
}
   