package be.helha.groupe5.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name="UtilisateurEnregistre.FindAll",
			query="SELECT u from UtilisateurEnregistre u"),
	@NamedQuery(name="UtilisateurEnregistre.FindOne",
			query="SELECT u from UtilisateurEnregistre u WHERE u.nom LIKE :nom")
})
public class UtilisateurEnregistre implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nom;
	private String prenom;
	private String pseudoUtilisateur;
	private String password; 
	private String email; 
	private String tel;

	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST)
	private Adresse adressePostale;

	//------------------------------------Constructor-----------------------------------	
	public UtilisateurEnregistre(){}

	public UtilisateurEnregistre(String nom){
		setNom(nom);setPrenom("");setPseudoUtilisateur("");
		setPassword("");setEmail("");setTel("");
	}

	public UtilisateurEnregistre(Integer id,String pseudoUtilisateur,String password,String email,String tel,int numRue,String nomRue,String localite,int codePostal){
		this.setId(id);
		this.pseudoUtilisateur=pseudoUtilisateur;
		this.password=password;
		this.email = email;
		this.tel=tel;
	}
	public UtilisateurEnregistre(String pseudoUtilisateur,String password,String email,String tel){
		this.pseudoUtilisateur=pseudoUtilisateur;
		this.password=password;
		this.email = email;
		this.tel=tel;
	}
	public UtilisateurEnregistre(String nom, String prenom,String pseudoUtilisateur,String password,String email,String tel){
		this.nom=nom;
		this.prenom=prenom;
		this.pseudoUtilisateur=pseudoUtilisateur;
		this.password=password;
		this.email = email;
		this.tel=tel;
	}
	public UtilisateurEnregistre(String nom, String prenom,String pseudoUtilisateur,String password,String email,String tel,
			String numRue, String nomRue, String localite,int codePostal){
		this.nom=nom;
		this.prenom=prenom;
		this.pseudoUtilisateur=pseudoUtilisateur;
		this.password=password;
		this.email = email;
		this.tel=tel;
		this.adressePostale=new Adresse(numRue,codePostal,nomRue,localite,false,"domicile");
	}


	public UtilisateurEnregistre(String pseudoUtilisateur2, String password2, String email2, String tel2, String numRue,
			String nomRue, String localite, int codePostal) {
		// TODO Auto-generated constructor stub
		this.pseudoUtilisateur=pseudoUtilisateur2;
		this.password=password2;
		this.email=email2;
		this.adressePostale=new Adresse(numRue,codePostal,nomRue,localite);
	}

	//------------------------------Getter & Setter------------------------------------------
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
	public Adresse getAdressePostale() {
		return adressePostale;
	}

	public void setAdressePostale(Adresse adressePostale) {
		this.adressePostale = adressePostale;
	}

	//----------------------------------------otherMethods()----------------------------------
	@Override
	public String toString() {
		return "UtilisateurEnregistre [id=" + id + ", pseudoUtilisateur=" + pseudoUtilisateur + ", password=" + password
				+ ", email=" + email + ", tel=" + tel + "]";
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
