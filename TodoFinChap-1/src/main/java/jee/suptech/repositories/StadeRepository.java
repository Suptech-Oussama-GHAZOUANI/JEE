package jee.suptech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jee.suptech.entities.Stade;

@Repository
public interface StadeRepository extends JpaRepository<Stade, Long> {
	
}