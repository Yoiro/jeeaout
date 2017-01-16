package be.helha.groupe3.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name="Produit.FindAll",
				query="SELECT p from Produit p")
})
public class Produit implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nom;
	private double prix;
	private String description;
	
	@ManyToOne
	private Distributeur distrib;
	
	public Produit(){}
	public Produit(String nom, double prix, String description, Distributeur distrib){
		super();
		this.nom = nom;
		this.prix = prix;
		this.description = description;
		this.distrib=distrib;
	}
	public Produit(Integer id, String nom, double prix, String description) {
		super();
		this.id = id;
		this.nom = nom;
		this.prix = prix;
		this.description = description;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
