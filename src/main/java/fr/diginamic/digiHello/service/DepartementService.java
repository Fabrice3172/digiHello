package fr.diginamic.digiHello.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.diginamic.digiHello.model.Departement;
import fr.diginamic.digiHello.repository.DepartementRepository;

@Service
public class DepartementService {

	@Autowired
	DepartementRepository departementRepository;
	
	public boolean create(Departement department) {
		try {
			departementRepository.save(department);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	public List<Departement> findAll() {
		 return departementRepository.findAll();
	}

	public Departement findByCode(String code) {
		return departementRepository.findByCode(code);
	}

	public Departement findById(Integer id) {
		return departementRepository.findById(id).get();
	}
	
	public boolean update(Departement departement) {
			departementRepository.save(departement);
			return true;
		
	}
	
	public boolean delete(Integer id) {
			departementRepository.deleteById(id);;
			return true;
	
	}
	
}
