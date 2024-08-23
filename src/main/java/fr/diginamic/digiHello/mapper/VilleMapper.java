package fr.diginamic.digiHello.mapper;

import org.springframework.beans.factory.annotation.Autowired;

import fr.diginamic.digiHello.dto.VilleDto;
import fr.diginamic.digiHello.model.Departement;
import fr.diginamic.digiHello.model.Ville;
import fr.diginamic.digiHello.service.DepartementService;
import fr.diginamic.digiHello.service.VilleService;

public class VilleMapper {

	@Autowired
	VilleService villeService;
	@Autowired
	DepartementService departementService;
	
	public VilleDto toDto(Ville ville) {
		return null;
	}
	
	public Ville toBean(VilleDto villeDto) {
		
		Ville ville= new Ville();
		
		ville.setNom(villeDto.getNomVille());
		ville.setNbHabitants(villeDto.getNbHabitantsVille());
		
		Departement departement = new Departement();
		
		departement.setCode(villeDto.getCodeDepartement());
		departement.setNom(villeDto.getNomDepartement());
		ville.setDep(departement);
		
		Ville v = villeService.extractVille(villeDto.getNomVille());
		
		if (v != null) {
			ville.setId(v.getId());
		}
		
		Departement dep = departementService.findByCode(villeDto.getCodeDepartement());
		if(dep !=null) {
			departement.setId(dep.getId());
		}
		return ville;
	}
}
