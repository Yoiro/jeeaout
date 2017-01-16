package be.helha.groupe3.controllers;

import java.util.List;

import javax.ejb.EJB;

import be.helha.groupe3.entities.Produit;
import daobe.helha.groupe3.daos.DAOProduitLocalBean;

public class ProduitBeanController {
	
	private String nom;
	private double prix;
	private String description;
	private boolean stock;
	@EJB
	DAOProduitLocalBean daoProduitLocalBean;
	
	//Getters & Setters
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
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
	//------------------------------------------//
	
	//Méthodes de vues//
	public String doFindAll(){
		return "tous-les-produits.xhtml";
	}
	//------------------------------------------//
	
	//------------------------------------------//
	//Méthodes d'accès à la Base de Données//
	public List<Produit> getAll(){
		return daoProduitLocalBean.getAll();
	}
	//------------------------------------------//
}
