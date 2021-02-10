package fr.doranco.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cours", propOrder = {
	"id", "titre", "duree"
})
public class Cours {
	
	// @XmlTransient: permet de ne pas considérer un paramètre.
	
	@XmlElement(required = false)
	private Integer id;
	@XmlElement(required = true)
	private String titre;
	@XmlElement(required = true)
	private Integer duree;
	
	public Cours() {}

	public Cours(String titre, Integer duree) {
		this.titre = titre;
		this.duree = duree;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Integer getDuree() {
		return duree;
	}

	public void setDuree(Integer duree) {
		this.duree = duree;
	}

	@Override
	public String toString() {
		return "Cours [id=" + id + ", titre=" + titre + ", duree=" + duree + "]";
	}

}
