package be.helha.groupe3.controllers;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import be.helha.groupe3.daos.DAOUserLocalBean;

@Named
@RequestScoped
public class InscriptionBeanController {
	private String nom,prenom,pseudoUtilisateur,password,email,tel;
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
	//----------------------------------------------------//
	//DatabaseAccess//
	public void inscription(){
		daoUserLocalBean.inscription();
		
	}
	

	
}
