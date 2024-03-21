package jee.suptech.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jee.suptech.entities.Equipe;

@Repository
public interface EquipeRepository extends JpaRepository<Equipe, Long> {
	
    List<Equipe> findByPays(String pays);
    Optional<Equipe> findByNomEquipe(String nomEquipe);


}