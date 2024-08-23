package fr.diginamic.digiHello.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.diginamic.digiHello.dto.VilleDto;
import fr.diginamic.digiHello.model.Departement;
import fr.diginamic.digiHello.model.Ville;
import fr.diginamic.digiHello.repository.DepartementRepository;
import fr.diginamic.digiHello.repository.VilleRepository;
import jakarta.annotation.PostConstruct;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.PersistenceContext;
//import jakarta.persistence.TypedQuery;

@Service
public class VilleService {
	
	/* @PersistenceContext
	private EntityManager em;
	*/
	
	@Autowired
	VilleRepository villeRepository;
	@Autowired
	DepartementRepository departementRepository;
	
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
		
		Departement dep1 = new Departement("31000","Haute Garonne");
		
		Departement dep2 = new Departement("34000","Hérault");
		
		departementRepository.save(dep1);
		
		departementRepository.save(dep2);
		
		
		//villeService.insertVille(new Ville("Toulouse", 700000));
		villeRepository.save(new Ville("Toulouse", 700000, dep1));
		//villes.add(montp);
		//villeService.insertVille(new Ville("Montpellier",4000000));
		villeRepository.save(new Ville("Montpellier", 400000, dep2));
	}
	
	
	public List<Ville> extractVilles() {
		//TypedQuery<Ville> query = em.createQuery("SELECT p FROM Ville p", Ville.class);
		//return query.getResultList();
		return villeRepository.findAll();
	}
	
	public Optional<Ville> extractVille(int idVille) {
		//TypedQuery<Ville> query = em.createQuery("SELECT p FROM Ville p WHERE p.id=idVille", Ville.class);
		//return query.getSingleResult();
		return villeRepository.findById(idVille);
	}
	
	public Ville extractVille(String nom) {
		//TypedQuery<Ville> query = em.createQuery("SELECT p FROM Ville p WHERE p.nom=nom", Ville.class);
		//return query.getSingleResult();
		return villeRepository.findByNom(nom);
	}
	
	@Transactional
	public void insertVille(Ville ville) {
		//TypedQuery<Ville> query = em.createQuery("UPDATE p=ville FROM VILLE", Ville.class);
		//if (em != null) {
			//em.persist(ville);
		villeRepository.save(ville);
		
		/*}
		else {
			System.out.println("Erreur persistence em");
		}*/
		
		//return extractVilles();
	}
	
	@Transactional
	public List<Ville> modifierVille(Ville villeModifiee) {
		
		Optional<Ville> optionalVille = villeRepository.findById(villeModifiee.getId());
		
		if (optionalVille.isPresent()) {
			Ville ville = optionalVille.get();
			ville.setNom(villeModifiee.getNom());
			ville.setNbHabitants(villeModifiee.getNbHabitants());
			
			/*if (em != null) em.merge(v);
			else {
				System.out.println("Erreur persistence em");
			}*/
			villeRepository.save(ville);
		}
		
		return extractVilles();
	}
	
	@Transactional
	public List<Ville> supprimerVille(int idVille) {
		//TypedQuery<Ville> query = em.createQuery("DELETE p FROM Ville p WHERE p.id=idVille", Ville.class);
		villeRepository.deleteById(idVille);
		return extractVilles();
	}
	
	public List<Ville> findByNbHabitantsGreaterThan(long min) {
		return villeRepository.findByNbHabitantsGreaterThan(min);
	}
	
	public List<Ville> findByNbHabitantsBetweenMinMax(long min, long max) {
		return villeRepository.findByNbHabitantsBetweenMinMax(min, max);
	}
	
}
