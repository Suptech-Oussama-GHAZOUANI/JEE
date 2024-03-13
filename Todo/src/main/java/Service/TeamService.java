package Service;

import java.util.List;

import org.springframework.stereotype.Service;

import Entities.Team;
import Repositories.TeamRepository;

@Service
public class TeamService {
    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Team getTeamById(Long id) {
        return teamRepository.findById(id).orElse(null);
    }

    public List<Team> getTeamsByCountry(String country) {
        return teamRepository.findByCountry(country);
    }

    // Add more methods as needed for team management

}
