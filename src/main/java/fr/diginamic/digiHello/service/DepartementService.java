package fr.diginamic.digiHello.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.diginamic.digiHello.dto.DepartementDto;
import fr.diginamic.digiHello.mapper.DepartementMapper;
import fr.diginamic.digiHello.model.Departement;
import fr.diginamic.digiHello.model.Ville;
import fr.diginamic.digiHello.repository.DepartementRepository;

@Service
public class DepartementService {

	@Autowired
	DepartementRepository departementRepository;
	
	public boolean create(DepartementDto department) {
		try {
			DepartementMapper dMap = new DepartementMapper();
			
			departementRepository.save(dMap.toBean(department));
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	public List<DepartementDto> findAll() {
		
		List<Departement> lDep  = new ArrayList<Departement>();
		
		lDep = departementRepository.findAll();
		
		List<DepartementDto> lDto = new ArrayList<DepartementDto>();
		
		for (Departement d : lDep) {
			DepartementDto dDto = new DepartementDto();
			
			dDto.setCodeDepartement(d.getCode());
			dDto.setNomDepartement(d.getNom());
			dDto.setId(d.getId());
			
			Integer nbHabitantsDepartement = 0;
			for (Ville v : d.getListeVille()) {
				nbHabitantsDepartement = nbHabitantsDepartement + v.getNbHabitants();
			}
			dDto.setNbHabitantsDepartement(nbHabitantsDepartement);
			
			lDto.add(dDto);
		}
		
		return lDto;
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
