package jee.suptech.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import jee.suptech.entities.Arbitre;
import jee.suptech.entities.Equipe;
import jee.suptech.entities.Match;
import jee.suptech.entities.Stade;
import jee.suptech.repositories.ArbitreRepository;
import jee.suptech.repositories.EquipeRepository;
import jee.suptech.repositories.MatchRepository;
import jee.suptech.repositories.StadeRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("todo2")
public class MatchController {

    @Autowired
    private MatchRepository matchRepository;
    @Autowired
    private EquipeRepository equipeRepository;
    @Autowired
    private ArbitreRepository arbitreRepository;
    @Autowired
    private StadeRepository stadeRepository;
    

    @PostMapping("match/1steq/{idequipe1}/2ndeq/{idequipe2}/arb/{idarbitre}/std/{idstade}")
	public Match addMatch(@PathVariable ("idstade") Long idstade,@PathVariable ("idarbitre") Long idarbitre,@PathVariable ("idequipe1") Long idequipe1,@PathVariable ("idequipe2") Long idequipe2,@RequestBody Match match) {
		     Optional<Equipe> equipe1=equipeRepository.findById(idequipe1);
	         Optional<Equipe> equipe2=equipeRepository.findById(idequipe2);
		     Optional<Arbitre> arbitre=arbitreRepository.findById(idarbitre);
		     Optional<Stade> stade=stadeRepository.findById(idstade);
		     if (equipe2.isPresent() & arbitre.isPresent() & stade.isPresent() & equipe1.isPresent()) {
		    	 match.setArbitre(arbitre.get());
	             match.setStade(stade.get());
	             List<Equipe> equipes = new ArrayList<>();
	             equipes.add(equipe1.get());
	             equipes.add(equipe2.get());
	             match.setEquipes(equipes);
		    	 return matchRepository.save(match);
		     }
		    	return null;  
	       }

    @GetMapping("matches")
    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }
    
    @GetMapping("matches/date/{date}")
    public List<Match> getMatchesByDate(@PathVariable String date) {
        LocalDate localDate = LocalDate.parse(date);
        return matchRepository.findByDateMatch(localDate);
    }

    @GetMapping("matches/id/{id}")
    public Match getMatchById(@PathVariable Long id) {
        Optional<Match> optionalMatch = matchRepository.findByIdMatch(id);
        if (optionalMatch.isPresent()) {
            return optionalMatch.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Match not found");
        }
    }

    
    @PutMapping("match/{id}")
    public Match updateMatch(@PathVariable Long id, @RequestBody Match newMatch) {
        return matchRepository.findById(id)
                .map(match -> {
                    match.setDateMatch(newMatch.getDateMatch());
                    match.setHeureMatch(newMatch.getHeureMatch());
                    return matchRepository.save(match);
                })
                .orElseGet(() -> {
                    newMatch.setIdMatch(id);
                    return matchRepository.save(newMatch);
                });
    }

    @DeleteMapping("match/{id}")
    public void deleteMatch(@PathVariable Long id) {
        matchRepository.deleteById(id);
    }

}
