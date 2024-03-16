package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entities.Stade;

@Repository
public interface StadeRepository extends JpaRepository<Stade, Long> {
}
