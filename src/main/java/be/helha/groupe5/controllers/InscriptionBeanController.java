package be.helha.groupe5.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import be.helha.groupe5.daos.DAOUserLocalBean;
import be.helha.groupe5.entities.UtilisateurEnregistre;
import be.helha.groupe5.patterns.UserBuilder;

@Named
@RequestScoped
public class InscriptionBeanController {
	
	private String nom,prenom,pseudoUtilisateur,password,email,tel;
	private String nomRue,numRue,localite;
	private int codePostal;
	private boolean isDistrib;
	UserBuilder builder;
	private List<UtilisateurEnregistre> users;
	
	@EJB private DAOUserLocalBean daoUserLocalBean;
	
	@PostConstruct
	public void init() {
		users = daoUserLocalBean.findAll();
	}
	
	//Getters & Setters//
	//----------------------------------------------------//
	public boolean getIsDistrib(){
		return isDistrib;
	}
	public void setIsDistrib(boolean ditr){
		isDistrib=ditr;
	}
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
	public String inscriptionPersonne(){
		if(daoUserLocalBean.findByName(pseudoUtilisateur)== null) {
			builder=new UserBuilder(isDistrib);
			builder.creerInformationsPersonne(nom, prenom, pseudoUtilisateur, password, email, tel);
			builder.creerAdresse(nomRue, numRue, codePostal, localite);
			UtilisateurEnregistre u=builder.getUser();
			UtilisateurEnregistre res = daoUserLocalBean.create(u);
			daoUserLocalBean.setUser(res);
			return "index.xhtml";
		}
		return "register-failed";
	}
	
}
