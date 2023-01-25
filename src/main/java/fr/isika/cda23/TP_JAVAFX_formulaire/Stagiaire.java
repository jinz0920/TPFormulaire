package fr.isika.cda23.TP_JAVAFX_formulaire;

public class Stagiaire {
	private String nom;
	private String prenom;
	private String naissance;
	private String genre;
	private String formation;
	private String location;

	public Stagiaire(String nom, String prenom, String naissance, String genre, String formation, String location) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.naissance = naissance;
		this.genre = genre;
		this.formation = formation;
		this.location = location;
	}

	@Override
	public String toString() {
		return "Stagiaire nom=" + nom + ", prenom=" + prenom + ", naissance=" + naissance + ", genre=" + genre
				+ ", formation=" + formation + ", location=" + location;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNaissance() {
		return naissance;
	}

	public void setNaissance(String naissance) {
		this.naissance = naissance;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getFormation() {
		return formation;
	}

	public void setFormation(String formation) {
		this.formation = formation;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
}
