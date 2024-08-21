package fr.diginamic.digiHello;

public class Ville {

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

	
	
}
