package Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import Entities.Match;
import Entities.Player;
import Entities.Stadium;
import Entities.Team;
import Repositories.MatchRepository;
import Repositories.PlayerRepository;
import Repositories.TeamRepository;

@Service
public class MatchService {
    private final MatchRepository matchRepository;
    private final TeamRepository teamRepository;
    private final PlayerRepository playerRepository;

    public MatchService(MatchRepository matchRepository, TeamRepository teamRepository, PlayerRepository playerRepository) {
        this.matchRepository = matchRepository;
        this.teamRepository = teamRepository;
        this.playerRepository = playerRepository;
    }
    
    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    public Match registerMatch(Match match) {
        // Implement logic to register match
        return matchRepository.save(match);
    }

    public Match modifyMatch(Long id, Match match) {
        // Implement logic to modify match
        Match existingMatch = matchRepository.findById(id).orElse(null);
        if (existingMatch != null) {
            existingMatch.setDate(match.getDate());
            existingMatch.setHomeTeam(match.getHomeTeam());
            existingMatch.setAwayTeam(match.getAwayTeam());
            existingMatch.setStadium(match.getStadium());
            // Set other attributes as needed
            return matchRepository.save(existingMatch);
        }
        return null;
    }

    public void deleteMatch(Long id) {
        // Implement logic to delete match
        matchRepository.deleteById(id);
    }

    public List<Match> getMatchesByDate(LocalDate date) {
        return matchRepository.findByDate(date);
    }

    public Stadium getStadiumByMatchId(Long id) {
        // Implement logic to get stadium by match id
        Match match = matchRepository.findById(id).orElse(null);
        if (match != null) {
            return match.getStadium();
        }
        return null;
    }

    public List<Team> getTeamsByMatchId(Long id) {
        // Implement logic to get teams by match id
        Match match = matchRepository.findById(id).orElse(null);
        List<Team> teams = new ArrayList<>();
        if (match != null) {
            teams.add(match.getHomeTeam());
            teams.add(match.getAwayTeam());
        }
        return teams;
    }

    public List<Team> getTeamsByCountry(String country) {
        // Implement logic to get teams by country
        return teamRepository.findByCountry(country);
    }

    public List<Player> getPlayersByTeam(String teamName) {
        // Implement logic to get players by team
        Team team = teamRepository.findByName(teamName);
        if (team != null) {
            return playerRepository.findByTeam(team);
        }
        return new ArrayList<>();
    }

    // Implement other methods as needed
}
