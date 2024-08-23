package fr.diginamic.digiHello.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.diginamic.digiHello.dto.VilleDto;
import fr.diginamic.digiHello.model.Ville;

public interface VilleRepository extends JpaRepository<Ville, Integer> {

	Ville findByNom(String nom);
	
	List<Ville> findByNomStartingWith(String letters);
	
	List<Ville> findByNbHabitantsGreaterThan(long min);
	
	@Query("SELECT v FROM Ville v WHERE v.nbHabitants in (:min, :max)")
	List<Ville> findByNbHabitantsBetweenMinMax(long min, long max);
	
	
	/*public List<Ville> extractVilles();
	public Optional<Ville> extractVille(int idVille);
	public Ville extractVille(String nom);
	public void insertVille(Ville ville);
	public List<Ville> modifierVille(Ville villeModifiee);
	
	public List<Ville> supprimerVille(int idVille);
	*/
	
}
