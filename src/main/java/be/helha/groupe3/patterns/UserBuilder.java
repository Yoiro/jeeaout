package be.helha.groupe3.patterns;

import be.helha.groupe3.entities.Acheteur;
import be.helha.groupe3.entities.Adresse;
import be.helha.groupe3.entities.Distributeur;
import be.helha.groupe3.entities.UtilisateurEnregistre;

public class UserBuilder {
	
	private UtilisateurEnregistre user;
	
	public UserBuilder(boolean b){newUser(b);}
	
	public void newUser(boolean b){ 
		user=(b?new Distributeur():new Acheteur());
	}
	
	public void creerInformationsPersonne(String nom, String prenom, String pseudoUtilisateur, String password, String email, String tel){
		user.setNom(nom);user.setPrenom(prenom);user.setPseudoUtilisateur(pseudoUtilisateur);
		user.setPassword(password);user.setEmail(email);user.setTel(tel);
	}
	public void creerAdresse(String nomRue,String numRue,int codePostal,String localite){
		Adresse a=new Adresse();
		a.setNomRue(nomRue);a.setNumRue(numRue);
		a.setCodePostal(codePostal);a.setLocalite(localite);
	}
	
	public UtilisateurEnregistre getUser(){
		return user;
	}
}
