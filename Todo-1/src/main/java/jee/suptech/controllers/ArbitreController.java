package jee.suptech.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jee.suptech.entities.Arbitre;
import jee.suptech.repositories.ArbitreRepository;

import java.util.List;

@RestController
@RequestMapping("todo")
public class ArbitreController {

    @Autowired
    private ArbitreRepository arbitreRepository;

    @PostMapping("arbitre")
    public Arbitre addArbitre(@RequestBody Arbitre arbitre) {
        return arbitreRepository.save(arbitre);
    }

    @GetMapping("arbitres")
    public List<Arbitre> getAllArbitres() {
        return arbitreRepository.findAll();
    }
    
    @PutMapping("arbitre/{id}")
    public Arbitre updateArbitre(@PathVariable Long id, @RequestBody Arbitre newArbitre) {
        return arbitreRepository.findById(id)
                .map(arbitre -> {
                    arbitre.setNom(newArbitre.getNom());
                    arbitre.setNationalite(newArbitre.getNationalite());
                    return arbitreRepository.save(arbitre);
                })
                .orElseGet(() -> {
                    newArbitre.setIdArbitre(id);
                    return arbitreRepository.save(newArbitre);
                });
    }

    @DeleteMapping("arbitre/{id}")
    public void deleteArbitre(@PathVariable Long id) {
        arbitreRepository.deleteById(id);
    }
}

