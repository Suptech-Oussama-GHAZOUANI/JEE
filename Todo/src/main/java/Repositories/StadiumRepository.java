package Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Entities.Stadium;

//StadiumRepository.java
@Repository
public interface StadiumRepository extends JpaRepository<Stadium, Long> {
 // Add more custom queries as needed
}