package be.helha.groupe3.controllers;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import be.helha.groupe3.daos.DAOUserLocalBean;
import be.helha.groupe3.entities.UtilisateurEnregistre;
import be.helha.groupe3.patterns.Builder;

@Named
@RequestScoped
public class InscriptionBeanController {
	
	private String nom,prenom,pseudoUtilisateur,password,email,tel;
	private String nomRue,numRue,localite;
	private int codePostal;
	Builder builder=new Builder();
	
	@EJB private DAOUserLocalBean daoUserLocalBean;
	
	//Getters & Setters//
	//----------------------------------------------------//
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
	//----------------------------------------------------//
	//Views//
	//----------------------------------------------------//
	public String doInscription(){
		return "inscription.xhtml";
	}
	public String doInscriptionAdresse(){
		return "inscription-adresse.xhtml";
	}
	//----------------------------------------------------//
	//DatabaseAccess//
	public void inscriptionPersonne(){
		builder.creerInformationsPersonne(nom, prenom, pseudoUtilisateur, password, email, tel);
		builder.creerAdresse(nomRue, numRue, codePostal, localite);
		UtilisateurEnregistre u=builder.getUser();
		daoUserLocalBean.inscription(u);
	}
	
}
