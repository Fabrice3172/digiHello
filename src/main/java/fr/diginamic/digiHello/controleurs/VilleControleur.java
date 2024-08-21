package fr.diginamic.digiHello.controleurs;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.digiHello.Ville;
import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/villes")
public class VilleControleur {
	
	private List<Ville> villes = new ArrayList<Ville>(); 
	
	private int id;
	
	
	@PostConstruct
	public void init() {
		Ville tlse = new Ville();
		tlse.setNom("Toulouse");
		tlse.setNbHabitants(700000);
		Ville montp = new Ville();
		montp.setNom("Montpellier");
		montp.setNbHabitants(400000);
		
		villes.add(tlse);
		villes.add(montp);
	}
	
	
	@GetMapping
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

}
