package fr.diginamic.digiHello.controleurs;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.digiHello.dto.DepartementDto;
import fr.diginamic.digiHello.mapper.DepartementMapper;
import fr.diginamic.digiHello.model.Departement;
import fr.diginamic.digiHello.model.Ville;
import fr.diginamic.digiHello.repository.DepartementRepository;
import fr.diginamic.digiHello.repository.VilleRepository;
import fr.diginamic.digiHello.service.DepartementService;
import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/departements")
public class DepartementControlleur {


	@Autowired
	//DepartementRepository departementRepository;
	private DepartementService departementService;
	
	
	/*@PostConstruct
	public void init() {
		
		departementRepository.save(new Departement("31000","Haute Garonne"));
		
		departementRepository.save(new Departement("34000","Hérault"));
	}*/
	
	
	@PostMapping
	public ResponseEntity<String> createDepartement(@RequestBody DepartementDto departement) {
		
		departementService.create(departement);
		return ResponseEntity.ok("Success !");
	}
	
	@GetMapping
	public List<DepartementDto> readDepartement() {
		
		return departementService.findAll();
	}
	
	@PutMapping
	public ResponseEntity<String> modifierDepartement(@RequestBody DepartementDto depModifie){
		
		departementService.create(depModifie);
		return ResponseEntity.ok("Success !");
	}
	
	
	@DeleteMapping("/{id}")
	public List<DepartementDto> supprimerDepartement(@PathVariable Integer id){
		//villeService.supprimerVille(idVille);
		
		departementService.delete(id);
		
		return readDepartement();
		
	}
}
