package be.helha.groupe3.controllers;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import be.helha.groupe3.daos.DAOProduitLocalBean;
import be.helha.groupe3.daos.DAOUserLocalBean;
import be.helha.groupe3.entities.Distributeur;
import be.helha.groupe3.entities.Produit;

@Named
@RequestScoped
public class ProduitBeanController{

	private String libelle;
	private double prix;
	private String description;
	private String nomDistributeur;
	private boolean stock;
		
	@EJB
	private DAOProduitLocalBean daoProduitLocalBean;
	
	@EJB
	private DAOUserLocalBean daoUserLocalBean;
	
	//Getters & Setters
	//------------------------------------------//
	
	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String nom) {
		this.libelle = nom;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isStock() {
		return stock;
	}

	public void setStock(boolean stock) {
		this.stock = stock;
	}
	
	public String getDistributeur(){
		return nomDistributeur;
	}
	
	public void setDistributeur(String distributeur){
		this.nomDistributeur=distributeur;
	}
	//------------------------------------------//
	
	//Méthodes de vues//
	//------------------------------------------//
	public String doIndex(){
		return "index.xhtml";
	}
	
	public String doCreateProduit(){
		return "creer-produit.xhtml";
	}
	
	public String doFindAll(){
		return "tous-les-produits.xhtml";
	}
	//------------------------------------------//
	
	//Méthodes d'accès à la Base de Données//
	//------------------------------------------//
	public void create(){
		
		Distributeur distributeur=new Distributeur();
		
		if(nomDistributeur==null)nomDistributeur="";
		if(daoUserLocalBean.findByName(nomDistributeur)!=null){
			distributeur=(Distributeur)daoUserLocalBean.findByName(nomDistributeur);
		}
		else{
			Distributeur d=new Distributeur(nomDistributeur);
		}
		
		if(libelle==null) libelle="";
		if(description=="null") description="";
		
		Produit p=new Produit(libelle,prix,description,distributeur);
		daoProduitLocalBean.create(p);
	}
	
	public List<Produit> getAll(){
		return daoProduitLocalBean.findAll();
	}
	//------------------------------------------//

}
