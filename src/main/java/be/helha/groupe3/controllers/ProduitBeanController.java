package be.helha.groupe3.controllers;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import be.helha.groupe3.daos.DAOProduitLocalBean;
import be.helha.groupe3.entities.Distributeur;
import be.helha.groupe3.entities.Produit;

@Named
@RequestScoped
public class ProduitBeanController {
	
	private String libelle;
	private double prix;
	private String description;
	private Distributeur distributeur;
	private boolean stock;
	
	@EJB
	DAOProduitLocalBean daoProduitLocalBean;
	
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
	//------------------------------------------//
	
	//Méthodes de vues//
	//------------------------------------------//
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
		Produit p=new Produit(libelle,prix,description,distributeur);
		daoProduitLocalBean.create(p);
	}
	
	public List<Produit> getAll(){
		return daoProduitLocalBean.getAll();
	}
	//------------------------------------------//
}
