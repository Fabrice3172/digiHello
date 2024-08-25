package fr.diginamic.digiHello.dto;

public class DepartementDto {

	private Integer Id;
	private String codeDepartement;
	private String nomDepartement;
	private Integer nbHabitantsDepartement;
	
	
	
	public DepartementDto() {
		super();
	}

	public DepartementDto(Integer id, String codeDepartement, String nomDepartement, Integer nbHabitantsDepartement) {
		super();
		Id = id;
		this.codeDepartement = codeDepartement;
		this.nomDepartement = nomDepartement;
		this.nbHabitantsDepartement = nbHabitantsDepartement;
	}

	
	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getCodeDepartement() {
		return codeDepartement;
	}
	public void setCodeDepartement(String codeDepartement) {
		this.codeDepartement = codeDepartement;
	}
	public String getNomDepartement() {
		return nomDepartement;
	}
	public void setNomDepartement(String nomDepartement) {
		this.nomDepartement = nomDepartement;
	}
	public Integer getNbHabitantsDepartement() {
		return nbHabitantsDepartement;
	}
	public void setNbHabitantsDepartement(Integer nbHabitantsDepartement) {
		this.nbHabitantsDepartement = nbHabitantsDepartement;
	}
	
	
	
}
