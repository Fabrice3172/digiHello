package fr.diginamic.digiHello.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.diginamic.digiHello.*;
import fr.diginamic.digiHello.dao.VilleDao;
import fr.diginamic.digiHello.model.Ville;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Service
public class VilleService implements VilleDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public List<Ville> extractVilles() {
		TypedQuery<Ville> query = em.createQuery("SELECT p FROM Ville p", Ville.class);
		return query.getResultList();
	}
	
	public Ville extractVille(int idVille) {
		TypedQuery<Ville> query = em.createQuery("SELECT p FROM Ville p WHERE p.id=idVille", Ville.class);
		return query.getSingleResult();
	}
	
	public Ville extractVille(String nom) {
		TypedQuery<Ville> query = em.createQuery("SELECT p FROM Ville p WHERE p.nom=nom", Ville.class);
		return query.getSingleResult();
	}
	
	@Transactional
	public void insertVille(Ville ville) {
		//TypedQuery<Ville> query = em.createQuery("UPDATE p=ville FROM VILLE", Ville.class);
		//if (em != null) {
			em.persist(ville);
		/*}
		else {
			System.out.println("Erreur persistence em");
		}*/
		
		//return extractVilles();
	}
	
	@Transactional
	public List<Ville> modifierVille(int idVille, Ville villeModifiee) {
		Ville v = extractVille(idVille);
		if (v!= null) {
			v.setId(villeModifiee.getId());
			v.setNom(villeModifiee.getNom());
			v.setNbHabitants(villeModifiee.getNbHabitants());
			
			if (em != null) em.merge(v);
			else {
				System.out.println("Erreur persistence em");
			}
		}
		
		return extractVilles();
	}
	
	@Transactional
	public List<Ville> supprimerVille(int idVille) {
		TypedQuery<Ville> query = em.createQuery("DELETE p FROM Ville p WHERE p.id=idVille", Ville.class);
		
		return extractVilles();
	}
}
