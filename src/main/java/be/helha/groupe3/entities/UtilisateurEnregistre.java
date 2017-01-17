package be.helha.groupe3.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name="UtilisateurEnregistre.FindAll",
				query="SELECT u from UtilisateurEnregistre u")
})

public class UtilisateurEnregistre implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String pseudoUtilisateur;
	private String password; 
	private String email; 
	private String tel;
	private int numRue;
	private String nomRue;
	private String localite;
	private int codePostal;
	
//------------------------------------Constructor-----------------------------------	
	public UtilisateurEnregistre(){}
	public UtilisateurEnregistre(Integer id,String pseudoUtilisateur,String password,String email,String tel,int numRue,String nomRue,String localite,int codePostal){
		this.setId(id);
		this.pseudoUtilisateur=pseudoUtilisateur;
		this.password=password;
		this.email = email;
		this.tel=tel;
		this.numRue=numRue;
		this.nomRue=nomRue;
		this.localite=localite;
		this.codePostal=codePostal;
	}
	public UtilisateurEnregistre(String pseudoUtilisateur,String password,String email,String tel,int numRue,String nomRue,String localite,int codePostal){
		this.pseudoUtilisateur=pseudoUtilisateur;
		this.password=password;
		this.email = email;
		this.tel=tel;
		this.numRue=numRue;
		this.nomRue=nomRue;
		this.localite=localite;
		this.codePostal=codePostal;
	}
	
	
	//------------------------------Getter & Setter------------------------------------------
	public void setId(Integer id) {
		this.id=id;
	}
	
	public Integer getID (){
		return id;
	}
	public String getPseudoUtilisateur() {
		return pseudoUtilisateur;
	}
	public void setPseudoUtilisateur(String pseudoUtilisateur) {
		this.pseudoUtilisateur = pseudoUtilisateur;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getNumRue() {
		return numRue;
	}
	public void setNumRue(int numRue) {
		this.numRue = numRue;
	}
	public String getNomRue() {
		return nomRue;
	}
	public void setNomRue(String nomRue) {
		this.nomRue = nomRue;
	}
	public String getLocalite() {
		return localite;
	}
	public void setLocalite(String localite) {
		this.localite = localite;
	}
	public int getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}
	
	
	//----------------------------------------otherMethods()----------------------------------
	@Override
	public String toString() {
		return "UtilisateurEnregistre [id=" + id + ", pseudoUtilisateur=" + pseudoUtilisateur + ", password=" + password
				+ ", email=" + email + ", tel=" + tel + ", numRue=" + numRue + ", nomRue=" + nomRue + ", localite="
				+ localite + ", codePostal=" + codePostal + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		UtilisateurEnregistre other = (UtilisateurEnregistre) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	} 
	
	
	
	
}