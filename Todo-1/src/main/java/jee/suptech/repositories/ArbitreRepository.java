package jee.suptech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jee.suptech.entities.Arbitre;

@Repository
public interface ArbitreRepository extends JpaRepository<Arbitre, Long> {
	
}