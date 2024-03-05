package ecole.suptech.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ecole.suptech.entities.Departement;
import ecole.suptech.entities.Employee;
import ecole.suptech.repositories.DepartementRepository;
import ecole.suptech.repositories.EmployeeRepository;

@RestController @RequestMapping("rh") 
public class EmployeeControllers {
	@Autowired	EmployeeRepository employeeRepository;
	@Autowired	DepartementRepository departementRepository;
	@PostMapping("departements/{idDep}/employes")
	public Employee AddEmployee(@RequestBody Employee employee,@PathVariable Long idDep) {
		Optional<Departement> departement=departementRepository.findById(idDep);
		if (departement!=null) {
			employee.setDepartement(departement.get());
			return employeeRepository.save(employee);
		}
		return null;
	}
	
	@GetMapping("employes")
	public List<Employee> getAllEmployee(){
		return employeeRepository.findAll();
	}
	
	@GetMapping("departements/{nomDep}/employes")
	public List<Employee> getAllEmployeeOfDep(@PathVariable String nomDep){
		return employeeRepository.findByDepartementNom(nomDep);
	}
	
	@GetMapping("employes/{id}")
	public Optional<Employee> getEmployeById(@PathVariable Long id) {
		return employeeRepository.findById(id);
	}
	
	@DeleteMapping("employes/{id}")
	public void deleteEmployeById(@PathVariable Long id) {
		employeeRepository.deleteById(id);
	}
	
	@DeleteMapping("employes")
	public void deleteEmploye(@RequestBody Employee employee) {
		employeeRepository.delete(employee);
	}
	
}
