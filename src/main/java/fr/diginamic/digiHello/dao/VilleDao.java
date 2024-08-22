package fr.diginamic.digiHello.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.diginamic.digiHello.model.Ville;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public interface VilleDao {

	List<Ville> extractVilles();
	
	Ville extractVille(int idVille);
	
	Ville extractVille(String nom);
	
	void insertVille(Ville ville);
	
	List<Ville> modifierVille(int idVille, Ville villeModifiee);
	
	List<Ville> supprimerVille(int idVille);
	
}
