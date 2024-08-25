package fr.diginamic.digiHello.mapper;

import org.springframework.stereotype.Service;

import fr.diginamic.digiHello.dto.DepartementDto;
import fr.diginamic.digiHello.dto.VilleDto;
import fr.diginamic.digiHello.model.Departement;
import fr.diginamic.digiHello.model.Ville;


@Service
public class DepartementMapper {

	public DepartementDto toDto(Departement departement) {
		
		Integer nbHabitantsDepartement = 0;
		
		for (Ville v : departement.getListeVille()) {
			nbHabitantsDepartement = nbHabitantsDepartement + v.getNbHabitants();
		}
		
		DepartementDto departementDto = new DepartementDto();
		departementDto.setNomDepartement(departement.getNom());
		departementDto.setCodeDepartement(departement.getCode());
		departementDto.setNbHabitantsDepartement(nbHabitantsDepartement);
		return departementDto;
	}
	
	public Departement toBean(DepartementDto depDto) {
		
		Departement dep= new Departement();
		
		dep.setNom(depDto.getNomDepartement());
		dep.setCode(depDto.getCodeDepartement());
		
		if(dep !=null) {
			dep.setId(depDto.getId());
		}
		return dep;
	}
	
}
