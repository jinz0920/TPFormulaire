package fr.isika.cda23.TP_JAVAFX_formulaire;

public class Localisation {
	private String ville;

	public Localisation(String ville) {
		super();
		this.ville = ville;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	@Override
	public String toString() {
		return this.ville;
	}

}
