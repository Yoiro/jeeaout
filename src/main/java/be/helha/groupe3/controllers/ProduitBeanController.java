package be.helha.groupe3.controllers;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import be.helha.groupe3.daos.DAOProduitLocalBean;
import be.helha.groupe3.entities.Distributeur;
import be.helha.groupe3.entities.Produit;

@Named
@RequestScoped
public class ProduitBeanController implements Controller{
	
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
	
	public Distributeur getDistributeur(){
		return distributeur;
	}
	
	public void setDistributeur(Distributeur distributeur){
		this.distributeur=distributeur;
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
		Produit p=new Produit(libelle,prix,description,distributeur);
		daoProduitLocalBean.create(p);
		doFindAll();
	}
	
	public List<Produit> getAll(){
		return daoProduitLocalBean.getAll();
	}
	//------------------------------------------//

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		return null;
	}
}
