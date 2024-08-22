package fr.diginamic.digiHello.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
public class Ville {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nom;
	
	private double nbHabitants;
	
	public Ville() {
		
	}

	

	public Ville(String nom, double nbHabitants) {
		super();
		this.nom = nom;
		this.nbHabitants = nbHabitants;
	}



	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getNbHabitants() {
		return nbHabitants;
	}

	public void setNbHabitants(double nbHabitants) {
		this.nbHabitants = nbHabitants;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	
}
