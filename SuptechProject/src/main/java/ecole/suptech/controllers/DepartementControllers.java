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
import ecole.suptech.repositories.DepartementRepository;

@RestController @RequestMapping("rh") 
public class DepartementControllers {
	@Autowired
	DepartementRepository departementRepository;
	@PostMapping("departements")
	public Departement AddDepartement(@RequestBody Departement departement) {
		return departementRepository.save(departement);
	}
	
	@GetMapping("departements")
	public List<Departement> getAllDepartement(){
		return departementRepository.findAll();
	}
	
	@GetMapping("departements/{id}")
	public Optional<Departement> getEmployeById(@PathVariable Long id) {
		return departementRepository.findById(id);
	}
	
	@DeleteMapping("departements/{id}")
	public void deleteEmployeById(@PathVariable Long id) {
		departementRepository.deleteById(id);
	}
	
	@DeleteMapping("departements")
	public void deleteEmploye(@RequestBody Departement departement) {
		departementRepository.delete(departement);
	}
	
}
