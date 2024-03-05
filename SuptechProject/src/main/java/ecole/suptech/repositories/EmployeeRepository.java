package ecole.suptech.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ecole.suptech.entities.Employee;

@Repository 
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	public List<Employee> findByDepartementNom(String nom);
}
