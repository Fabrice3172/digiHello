package fr.diginamic.digiHello.service;

import java.util.ArrayList;
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
import fr.diginamic.digiHello.exception.DigiHelloException;
import fr.diginamic.digiHello.mapper.VilleMapper;

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
	
	
	public List<VilleDto> extractVilles() {
		//TypedQuery<Ville> query = em.createQuery("SELECT p FROM Ville p", Ville.class);
		//return query.getResultList();
		List<Ville> lv = villeRepository.findAll();
		List<VilleDto> lvDto = new ArrayList<VilleDto>();
		/*List<VilleMapper> lvMap = new ArrayList<VilleMapper>();
		*/
		VilleDto vDto = new VilleDto();
		VilleMapper vMap = new VilleMapper();
		
		for (Ville v: lv) {
			vDto = vMap.toDto(v);
			lvDto.add(vDto);
		}
		
		return lvDto;
	}
	
	public VilleDto extractVille(int idVille) {
		//TypedQuery<Ville> query = em.createQuery("SELECT p FROM Ville p WHERE p.id=idVille", Ville.class);
		//return query.getSingleResult();
		
		Optional<Ville> ov = villeRepository.findById(idVille);
		
		Ville v = new Ville();
		v.setNom(ov.get().getNom());
		v.setDep(ov.get().getDep());
		v.setNbHabitants(ov.get().getNbHabitants());
		v.setId(ov.get().getId());
		
		VilleMapper vMap = new VilleMapper();
		
		return vMap.toDto(v);
	}
	
	public Ville extractVille(String nom) {
		//TypedQuery<Ville> query = em.createQuery("SELECT p FROM Ville p WHERE p.nom=nom", Ville.class);
		//return query.getSingleResult();
		
		VilleMapper vMap = new VilleMapper();
		
		
		return villeRepository.findByNom(nom);
	}
	
	@Transactional
	public void insertVille(VilleDto ville) throws DigiHelloException {
		VilleMapper vMap = new VilleMapper();
		
		villeValidation(vMap.toBean(ville));
		
		//TypedQuery<Ville> query = em.createQuery("UPDATE p=ville FROM VILLE", Ville.class);
		//if (em != null) {
			//em.persist(ville);
		
		
		villeRepository.save(vMap.toBean(ville));
		
		/*}
		else {
			System.out.println("Erreur persistence em");
		}*/
		
		//return extractVilles();
	}
	
	@Transactional
	public List<VilleDto> modifierVille(Ville villeModifiee) throws DigiHelloException {
		villeValidation(villeModifiee);
		
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
	public List<VilleDto> supprimerVille(int idVille) {
		//TypedQuery<Ville> query = em.createQuery("DELETE p FROM Ville p WHERE p.id=idVille", Ville.class);
		villeRepository.deleteById(idVille);
		return extractVilles();
	}
	
	public List<VilleDto> findByNbHabitantsGreaterThan(long min) {
		
		VilleMapper vMap = new VilleMapper();
		
		List<Ville> lv = new ArrayList<Ville>();
		
		lv = villeRepository.findByNbHabitantsGreaterThan(min);
		
		VilleDto vDto = new VilleDto();
		List<VilleDto> lvDto = new ArrayList<VilleDto>();
		
		for (Ville v : lv) {
			vDto = vMap.toDto(v);
			lvDto.add(vDto);
		}
		
		return lvDto;
	}
	
	public List<VilleDto> findByNbHabitantsBetweenMinMax(long min, long max) {
		
		List<Ville> lv = new ArrayList<Ville>();
		
		lv = villeRepository.findByNbHabitantsBetweenMinMax(min, max);
		
		List<VilleDto> lvDto = new ArrayList<VilleDto>();
		
		VilleDto vDto = new VilleDto();
		VilleMapper vMap = new VilleMapper();
		
		for (Ville v: lv) {
			vDto = vMap.toDto(v);
			lvDto.add(vDto);
		}
		
		return lvDto;
	}
	
	private void villeValidation(Ville v) throws DigiHelloException {
		
		if(v.getNbHabitants()<10) {
			throw new DigiHelloException("Une ville a, au moins, 10 habitants.");
		}
		
		if(v.getNom().length()<2) {
			throw new DigiHelloException("Le nom d'une ville a, au moins, deux caractères.");
		}
		
		if (v.getDep().getCode().length()!=2) {
			throw new DigiHelloException("Le code département doit être de deux caractères.");
		}
		
		/* Ville v2 = villeRepository.findByNameAndDepartmentCode(v.getNom(), v.getDep().getCode());
		if(v2 != null) {
			throw new DigiHelloException("Le nom de la ville est unique pour un département donné.");
		}
		*/
	}
}
