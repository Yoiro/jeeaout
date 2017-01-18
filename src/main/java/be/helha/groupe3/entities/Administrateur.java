package be.helha.groupe3.entities;



import be.helha.groupe3.entities.UtilisateurEnregistre;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Administrateur implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private static final String PSEUDO="admin";
	private static final String PASSWORD="mdp";

	private List<UtilisateurEnregistre>listeUtilisateur;
	private List<Commande>listeCommande;

	//------------------------Constructor -------------------------
	
	public Administrateur(){
		listeUtilisateur = new ArrayList<UtilisateurEnregistre>();
		listeCommande = new ArrayList<Commande>();
	}


	//-----------------------Getter & Setter----------------------
	
	
	//----------------------otherMethods()-------------------------
	public void ajouterUtilisateur(UtilisateurEnregistre u){
		if(!listeUtilisateur.contains(u)){
			listeUtilisateur.add(u);
		}
	}

	public void removeUtilisateur(UtilisateurEnregistre u){
		if(listeUtilisateur.contains(u)){
			listeUtilisateur.remove(u);
		}
	}
	
//	public void editUtilisateur(UtilisateurEnregistre nouv,UtilisateurEnregistre ancien){
//		for(UtilisateurEnregistre u : listeUtilisateur){
//			if(u.equals(ancien)){
//				;
//				
//			}
//		}
//		
//	}
}
