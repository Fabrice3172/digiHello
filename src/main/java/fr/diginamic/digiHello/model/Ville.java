package fr.diginamic.digiHello.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
public class Ville {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nom;
	
	private Integer nbHabitants;
	
	//private String codeDepartement;
	
	
	@ManyToOne
	@JoinColumn(name = "ID_DEP")
	@NotNull
	private Departement departement;
	
	
	public Ville() {
		
	}

	/*public Ville(String nom, double nbHabitants, String codeDepartement) {
		super();
		this.nom = nom;
		this.nbHabitants = nbHabitants;
		this.codeDepartement = codeDepartement;
	}*/


	public Ville(String nom, Integer nbHabitants, Departement departement) {
		super();
		this.nom = nom;
		this.nbHabitants = nbHabitants;
		this.departement = departement;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getNbHabitants() {
		return nbHabitants;
	}

	public void setNbHabitants(Integer nbHabitants) {
		this.nbHabitants = nbHabitants;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Departement getDep() {
		return departement;
	}

	public void setDep(Departement departement) {
		this.departement = departement;
	}

	@Override
	public String toString() {
		return "Ville [id=" + id + ", nom=" + nom + ", nbHabitants=" + nbHabitants + ", departement=" + departement + "]";
	}
	
	/*public String getCodeDepartement() {
		return codeDepartement;
	}

	public void setCodeDepartement(String codeDepartement) {
		this.codeDepartement = codeDepartement;
	}*/
	
	
	
	
	
}
