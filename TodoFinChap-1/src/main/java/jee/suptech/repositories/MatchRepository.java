package jee.suptech.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jee.suptech.entities.Match;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {
	
	public List<Match> findByDateMatch(LocalDate dateMatch);
    
	public Optional<Match> findByIdMatch(Long id);
}
