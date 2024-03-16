package repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entities.Equipe;

@Repository
public interface EquipeRepository extends JpaRepository<Equipe, Long> {
    List<Equipe> findByPays(String pays);
}
