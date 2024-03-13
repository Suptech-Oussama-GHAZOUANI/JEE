package Repositories;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fasterxml.jackson.databind.deser.DataFormatReaders.Match;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {
    List<Match> findByDate(LocalDate date);
}