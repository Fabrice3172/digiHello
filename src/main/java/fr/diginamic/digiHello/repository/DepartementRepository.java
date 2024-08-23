package fr.diginamic.digiHello.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.diginamic.digiHello.model.Departement;
import fr.diginamic.digiHello.model.Ville;

public interface DepartementRepository extends JpaRepository<Departement, Integer>{
	
	/*public boolean create(Departement department);
	public List<Departement> findAll();
	public boolean update(Departement departement);
	*/
	
	public Departement findByCode(String code);
	public void deleteByCode(String code);
	
	//public boolean delete(Integer id);
}
