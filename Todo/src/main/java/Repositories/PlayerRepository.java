package Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Entities.Player;
import Entities.Team;

//PlayerRepository.java
@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
 List<Player> findByTeam(Team team);
 List<Player> findByPositionAndTeam(String position, Team team);
}