package fr.diginamic.digiHello.controleurs;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

import jakarta.annotation.PostConstruct;
import fr.diginamic.digiHello.dao.VilleDao;
import fr.diginamic.digiHello.dto.VilleDto;
import fr.diginamic.digiHello.exception.DigiHelloException;
import fr.diginamic.digiHello.mapper.VilleMapper;
import fr.diginamic.digiHello.model.Departement;
import fr.diginamic.digiHello.model.Ville;
import fr.diginamic.digiHello.service.DepartementService;
import fr.diginamic.digiHello.service.VilleService;
import fr.diginamic.digiHello.repository.DepartementRepository;
import fr.diginamic.digiHello.repository.VilleRepository;

@RestController
@RequestMapping("/villes")
public class VilleControleur {
	
	//private List<Ville> villes = new ArrayList<Ville>(); 
	
	//private Integer id;
	
	@Autowired
	//private VilleDao villeDao;
	private VilleService villeService;
	//VilleRepository villeRepository;
	
	@Autowired
	//DepartementRepository departementRepository;
	private DepartementService departementService;
	
	
	
	
	/*@GetMapping
	public List<Ville> listeVilles() {
	
		return villes;
	}
	
	@PostMapping
	public ResponseEntity<String> addVille(@RequestBody Ville v) {
		
		for (Ville vv : villes) {
			if (vv.getNom().equals(v.getNom())) {
				return ResponseEntity.badRequest().body("La ville existe déjà !");
			}
		}
		
		
		v.setNom("Tours");
		v.setNbHabitants(136000);
		villes.add(v);
			
		return ResponseEntity.ok("Success !");
	}
	
	public Ville getVilleById(Integer id) {
		Ville vv = null;
		
		for (Ville v : villes) {
			if (id.equals(v.getId())) {
				vv = v;
			}
		}
		return vv;
	}
	*/
	@GetMapping
	public List<VilleDto> extractVilles() {
		return villeService.extractVilles();
		//return villeRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public VilleDto extractVille(@PathVariable("id") Integer idVille) {
		return villeService.extractVille(idVille);
		//return villeRepository.findById(idVille);
	}
	
	@GetMapping("/name/{name}")
	public Ville extractVille(@PathVariable("name") String nom) {
		return villeService.extractVille(nom);
		//return villeRepository.findByNom(nom);
	}
	
	@GetMapping("/startwith/{name}")
	public List<Ville> findByNomStartingWith(@PathVariable("name") String letters) {
		return ((VilleRepository) villeService).findByNomStartingWith(letters);
		//return villeRepository.findByNomStartingWith(letters);
	}
	
	@GetMapping("findMin/min/{min}")
	public List<VilleDto> findByNbHabitantsGreaterThan(@PathVariable("min") long min) {
		return villeService.findByNbHabitantsGreaterThan(min);
	}
	
	@GetMapping("findMinMax/minmax/{min}/{max}")
	public List<VilleDto> findByNbHabitantsBetweenMinMax(@PathVariable("min")long min, @PathVariable("max")long max) {
		return villeService.findByNbHabitantsBetweenMinMax(min, max);
	}
	
	@PostMapping
	public ResponseEntity<String> insertVille(@RequestBody Ville ville) throws DigiHelloException {
		VilleMapper vMap = new VilleMapper();
		villeService.insertVille(vMap.toDto(ville));
		//villeRepository.save(ville);
		return ResponseEntity.ok("Success !");
	}
	
	@PutMapping
	public ResponseEntity<String> modifierVille(@RequestBody Ville villeModifiee) throws DigiHelloException{
		villeService.modifierVille(villeModifiee);
		//villeRepository.save(villeModifiee);
		
		return ResponseEntity.ok("Success !");
	}
	
	@DeleteMapping("/{id}")
	public List<VilleDto> supprimerVille(@PathVariable("id") Integer idVille){
		villeService.supprimerVille(idVille);
		//villeRepository.deleteById(idVille);
		
		return villeService.extractVilles();
		
	}

}
