package jee.suptech.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import jee.suptech.entities.Match;
import jee.suptech.entities.Stade;
import jee.suptech.repositories.MatchRepository;
import jee.suptech.repositories.StadeRepository;

import java.util.List;

@RestController
@RequestMapping("todo2")
public class StadeController {

    @Autowired
    private StadeRepository stadeRepository;
    @Autowired
    private MatchRepository matchRepository;

    @PostMapping("stade")
    public Stade addStade(@RequestBody Stade stade) {
        return stadeRepository.save(stade);
    }

    @GetMapping("stades")
    public List<Stade> getAllStades() {
        return stadeRepository.findAll();
    }
    
    @PutMapping("stade/{id}")
    public Stade updateStade(@PathVariable Long id, @RequestBody Stade newStade) {
        return stadeRepository.findById(id)
                .map(stade -> {
                    stade.setNomStade(newStade.getNomStade());
                    stade.setVille(newStade.getVille());
                    return stadeRepository.save(stade);
                })
                .orElseGet(() -> {
                    newStade.setIdStade(id);
                    return stadeRepository.save(newStade);
                });
    }

    @DeleteMapping("stade/{id}")
    public void deleteStade(@PathVariable Long id) {
        stadeRepository.deleteById(id);
    }
    
    @GetMapping("match/{id}/stade")
    public Stade getStadeByMatchId(@PathVariable Long id) {
        Match match = matchRepository.findByIdMatch(id).orElseThrow(() -> new ResponseStatusException(
            HttpStatus.NOT_FOUND, "Match not found with id " + id
        ));
        return match.getStade();
    }
    

}
