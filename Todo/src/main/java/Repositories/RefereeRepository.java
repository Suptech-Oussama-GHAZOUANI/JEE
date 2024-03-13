package Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Entities.Referee;

//RefereeRepository.java
@Repository
public interface RefereeRepository extends JpaRepository<Referee, Long> {
 // Add more custom queries as needed



}