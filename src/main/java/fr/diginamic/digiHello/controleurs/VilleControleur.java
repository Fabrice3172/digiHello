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

import jakarta.annotation.PostConstruct;
import fr.diginamic.digiHello.dao.VilleDao;
import fr.diginamic.digiHello.model.Ville;
import fr.diginamic.digiHello.service.VilleService;

@RestController
@RequestMapping("/villes")
public class VilleControleur {
	
	//private List<Ville> villes = new ArrayList<Ville>(); 
	
	private Integer id;
	
	@Autowired
	//private VilleDao villeDao;
	private VilleService villeService;
	
	@PostConstruct
	public void init() {
		/*Ville tlse = new Ville();
		tlse.setNom("Toulouse");
		tlse.setNbHabitants(700000);
		Ville montp = new Ville();
		montp.setNom("Montpellier");
		montp.setNbHabitants(400000);
		*/
		//villes.add(tlse);
		villeService.insertVille(new Ville("Toulouse", 700000));
		//villes.add(montp);
		villeService.insertVille(new Ville("Montpellier",4000000));
	}
	
	
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
	public List<Ville> extractVilles() {
		return villeService.extractVilles();
	}
	
	@GetMapping("/{id}")
	public Ville extractVille(@PathVariable("id") int idVille) {
		return villeService.extractVille(idVille);
	}
	
	@GetMapping("/name/{name}")
	public Ville extractVille(@PathVariable("name") String nom) {
		return villeService.extractVille(nom);
	}
	
	@PostMapping
	public ResponseEntity<String> insertVille(@RequestBody Ville ville) {
		villeService.insertVille(ville);
		return ResponseEntity.ok("Success !");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> modifierVille(@PathVariable("id") int idVille,@RequestBody Ville villeModifiee){
		villeService.modifierVille(idVille, villeModifiee);
		return ResponseEntity.ok("Success !");
	}
	
	@DeleteMapping("/{id}")
	public List<Ville> supprimerVille(@PathVariable("id") int idVille){
		villeService.supprimerVille(idVille);
		return villeService.extractVilles();
		
	}

}
