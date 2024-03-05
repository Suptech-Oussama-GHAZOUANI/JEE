package ecole.suptech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ecole.suptech.entities.Departement;

@Repository 
public interface DepartementRepository extends JpaRepository<Departement, Long> {
	
}
