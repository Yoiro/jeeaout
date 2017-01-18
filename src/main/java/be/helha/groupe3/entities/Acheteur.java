package be.helha.groupe3.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



@Entity
/** Classe qui rerésente l'acheteur qui est enregistré et connecté sur le site
 * 	Hérite de la super classe UtilisateurEnregistre 
 */
public class Acheteur extends UtilisateurEnregistre implements Serializable{

	@OneToOne
	private Panier panier;
	
	@OneToMany
	private List<Commande>listeCommande;
	
	
	//CONSTRUCTORS//
	//---------------------------------------------------------//
	public Acheteur(){}
	//Constructeur avec utilisation de l'ID pour l'acheteur -> UtilisateurEnregistre (super)
	public Acheteur(Integer id,String pseudoUtilisateur,String password,String email,String tel,int numRue,String nomRue,String localite,int codePostal){
//		super(id,pseudoUtilisateur,password,email,tel,numRue,nomRue,localite,codePostal);
		this.listeCommande=new ArrayList<Commande>();
	}
	//Constructeur sans utilisation de l'ID pour l'acheteur -> UtilisateurEnregistre (super)
	public Acheteur(String pseudoUtilisateur,String password,String email,String tel,String numRue,String nomRue,String localite,int codePostal){
//		super(pseudoUtilisateur,password,email,tel,numRue,nomRue,localite,codePostal);
		this.listeCommande=new ArrayList<Commande>();
	}
	
	public Acheteur(String nom,String prenom,String pseudoUtilisateur,String password,String email,String tel,
			String numRue,String nomRue,String localite, int codePostal){
		this.listeCommande=new ArrayList<Commande>();
	}
	
	//--------------------------------------------------//
	
	public boolean ajouterCommande(Commande commande){
		return listeCommande.add(commande);
	}
	
	public boolean annulerCommande(Commande commande){
		return listeCommande.remove(commande);
	}
	
	
}
