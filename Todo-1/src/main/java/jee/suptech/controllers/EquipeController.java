package jee.suptech.controllers;

import java.util.List;

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
import jee.suptech.repositories.EquipeRepository;
import jee.suptech.repositories.JoueurRepository;

@RestController
@RequestMapping("todo")

public class EquipeController {
	@Autowired  JoueurRepository joueurRepository;
	@Autowired  EquipeRepository  equipeRepository;
	
	@PostMapping("equipe")
	public Equipe addEquipe(@RequestBody Equipe equipe) {
		return equipeRepository.save(equipe) ;
	}
	
	@GetMapping("equipes")
	private List<Equipe> getAllEquipes (@RequestBody Equipe equipe){   
		return equipeRepository.findAll();	 
	}
	
	@GetMapping("equipes/pays/{pays}")
    public List<Equipe> getEquipesByPays(@PathVariable String pays) {
        return equipeRepository.findByPays(pays);
    }

    @GetMapping("equipes/nom/{nomEquipe}")
    public List<Equipe> getEquipesByNom(@PathVariable String nomEquipe) {
        return equipeRepository.findByNomEquipe(nomEquipe);
    }
    
    @PutMapping("equipe/{id}")
    public Equipe updateEquipe(@PathVariable Long id, @RequestBody Equipe newEquipe) {
        return equipeRepository.findById(id)
                .map(equipe -> {
                    equipe.setNomEquipe(newEquipe.getNomEquipe());
                    equipe.setPays(newEquipe.getPays());
                    return equipeRepository.save(equipe);
                })
                .orElseGet(() -> {
                    newEquipe.setIdEquipe(id);
                    return equipeRepository.save(newEquipe);
                });
    }

    @DeleteMapping("equipe/{id}")
    public void deleteEquipe(@PathVariable Long id) {
        equipeRepository.deleteById(id);
    }

	   
}
