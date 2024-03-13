package Controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Entities.Match;
import Entities.Player;
import Entities.Stadium;
import Entities.Team;
import Service.MatchService;

//MatchController.java
@RestController
@RequestMapping("/matches")
public class MatchController {
	@Autowired
 private final MatchService matchService;

 public MatchController(MatchService matchService) {
     this.matchService = matchService;
 }

 @GetMapping("/all")
 public List<Match> getAllMatches() {
     return matchService.getAllMatches();
 }

 @PostMapping("/register")
 public Match registerMatch(@RequestBody Match match) {
     return matchService.registerMatch(match);
 }

 @PutMapping("/modify/{id}")
 public Match modifyMatch(@PathVariable Long id, @RequestBody Match match) {
     return matchService.modifyMatch(id, match);
 }

 @DeleteMapping("/delete/{id}")
 public void deleteMatch(@PathVariable Long id) {
     matchService.deleteMatch(id);
 }

 @GetMapping("/date/{date}")
 public List<Match> getMatchesByDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
     return matchService.getMatchesByDate(date);
 }

 @GetMapping("/stadium/{id}")
 public Stadium getStadiumByMatchId(@PathVariable Long id) {
     return matchService.getStadiumByMatchId(id);
 }

 @GetMapping("/teams/{id}")
 public List<Team> getTeamsByMatchId(@PathVariable Long id) {
     return matchService.getTeamsByMatchId(id);
 }
 


 // Implement other endpoints as needed
}
