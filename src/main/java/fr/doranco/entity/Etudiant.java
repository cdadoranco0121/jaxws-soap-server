package fr.doranco.entity;

public class Etudiant {
	
	private Integer id;
	private String nom;
	private String prenom;
	private String specialite;

	public Etudiant() {}

	public Etudiant(String nom, String prenom, String specialite) {
		this.nom = nom;
		this.prenom = prenom;
		this.specialite = specialite;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
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

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	@Override
	public String toString() {
		return "Etudiant [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", specialite=" + specialite + "]";
	}

}
