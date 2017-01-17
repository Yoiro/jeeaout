
package be.helha.groupe3.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import be.helha.groupe3.entities.Produit;

@Entity
public class Distributeur extends UtilisateurEnregistre implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String biographie;
	
	@OneToMany
	private List<Produit> produitsProposes;
	
	
	//---------------------------------Constructor---------------------------------
	
	public Distributeur(){}
	
	public Distributeur(String nom){
		super(nom);
	}
	
	//Constructeur Distributeur avec utilisation de l'ID de la super classe UtilisateurEnregistre
	public Distributeur(Integer id,String pseudoUtilisateur,String password,String email,String tel,int numRue,String nomRue,String localite,int codePostal,String biographie) {
		super(id,pseudoUtilisateur,password,email,tel,numRue,nomRue,localite,codePostal);
		this.biographie = biographie;
		this.produitsProposes=new ArrayList<Produit>();
	}
	//Constructeur Distributeur sans utiliation de l'ID de la super classe UtilisateurEnregistre
	public Distributeur(String pseudoUtilisateur,String password,String email,String tel,int numRue,String nomRue,String localite,int codePostal,String biographie) {
		super(pseudoUtilisateur,password,email,tel,numRue,nomRue,localite,codePostal);
		this.biographie = biographie;
		this.produitsProposes=new ArrayList<Produit>();
	}
	
	//---------------------------Getter & Setter------------------------------
	public String getBiographie() {
		return biographie;
	}
	public void setBiographie(String biographie) {
		this.biographie = biographie;
	}

	@Override
	public String toString() {
		return super.toString()+" Distributeur [biographie=" + biographie + ", produitsProposés="
				+ produitsProposes + "]";
	}

	//---------------------------otherMetods()--------------------------------
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getID() == null) ? 0 : getID().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Distributeur other = (Distributeur) obj;
		if (super.getID() == null) {
			if (other.getID() != null)
				return false;
		} else if (!getID().equals(other.getID()))
			return false;
		return true;
	}
	
	
}
