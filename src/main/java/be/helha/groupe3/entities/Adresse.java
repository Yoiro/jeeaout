package be.helha.groupe3.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Adresse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String nomRue;
	private String numRue;
	private int codePostal;
	private String localite;
	private Boolean isPointVente=false;
	private String nomAdresse="domicile";
	
	
	//---------------------------Constructor---------------------------------------
	public Adresse(){}
	
	public Adresse(String numRue,int codePostal,String nomRue,String localite,Boolean isPointVente,String nomAdresse){
		setNumRue(numRue);
		setNomRue(nomRue);
		setCodePostal(codePostal);
		setLocalite(localite);
		setIsPointVente(isPointVente);
		if(isPointVente==true){
			setNomAdresse(nomAdresse);
		}else setNomAdresse("Domicile");
	}
	
	public Adresse(String numRue2, int codePostal2, String nomRue2, String localite2) {
		// TODO Auto-generated constructor stub
		setNumRue(numRue2);
		setCodePostal(codePostal2);
		setNomRue(nomRue2);
		setLocalite(localite2);
	}

	//---------------------------Getter & Setter-----------------------------------
	public String getNomRue() {
		return nomRue;
	}

	public void setNomRue(String nomRue) {
		this.nomRue = nomRue;
	}

	public String getNumRue() {
		return numRue;
	}

	public void setNumRue(String numRue) {
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
