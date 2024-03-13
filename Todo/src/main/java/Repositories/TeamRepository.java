package Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Entities.Team;

//TeamRepository.java
@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
 List<Team> findByCountry(String country);
 Team findByName(String name);
}