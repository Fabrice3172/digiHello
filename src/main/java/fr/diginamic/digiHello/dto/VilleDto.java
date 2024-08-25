package fr.diginamic.digiHello.dto;

public class VilleDto {

	private Integer Id;
	private String nomVille;
	private Integer nbHabitantsVille;
	
	private String codeDepartement;
	private String nomDepartement;
	
	public VilleDto() {
		super();
	}

	public VilleDto(Integer id, String nomVille, Integer nbHabitantsVille, String codeDepartement,
			String nomDepartement) {
		super();
		Id = id;
		this.nomVille = nomVille;
		this.nbHabitantsVille = nbHabitantsVille;
		this.codeDepartement = codeDepartement;
		this.nomDepartement = nomDepartement;
	}
	
	

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getNomVille() {
		return nomVille;
	}
	public void setNomVille(String nomVille) {
		this.nomVille = nomVille;
	}
	public Integer getNbHabitantsVille() {
		return nbHabitantsVille;
	}
	public void setNbHabitantsVille(Integer nbHabitantsVille) {
		this.nbHabitantsVille = nbHabitantsVille;
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
	
	
	
}
