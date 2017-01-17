package be.helha.groupe3.entities;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Adresse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nomRue;
	private int numRue;
	private int codePostal;
	private String localite;
	private Boolean isPointVente;
	private String nomAdresse;
	
	//---------------------------Constructor---------------------------------------
	public Adresse(){}
	public Adresse(int numRue,String nomRue,int codePostal,String localite,Boolean isPointVente,String nomAdresse){
		setNumRue(numRue);
		setNomRue(nomRue);
		setCodePostal(codePostal);
		setLocalite(localite);
		setIsPointVente(isPointVente);
		if(isPointVente==true){
			setNomAdresse(nomAdresse);
		}else setNomAdresse("Domicile");
	}
	
	//---------------------------Getter & Setter-----------------------------------
	public String getNomRue() {
		return nomRue;
	}

	public void setNomRue(String nomRue) {
		this.nomRue = nomRue;
	}

	public int getNumRue() {
		return numRue;
	}

	public void setNumRue(int numRue) {
		this.numRue = numRue;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public String getLocalite() {
		return localite;
	}

	public void setLocalite(String localite) {
		this.localite = localite;
	}

	public Boolean getIsPointVente() {
		return isPointVente;
	}

	public void setIsPointVente(Boolean isPointVente) {
		this.isPointVente = isPointVente;
	}

	public String getNomAdresse() {
		return nomAdresse;
	}

	public void setNomAdresse(String nomAdresse) {
		this.nomAdresse = nomAdresse;
	}
	
	//------------------------otherMethods()--------------------------
	
}
