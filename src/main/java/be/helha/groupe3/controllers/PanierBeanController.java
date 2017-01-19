package be.helha.groupe3.controllers;

import java.util.HashMap;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import be.helha.groupe3.daos.DAOPanierLocalBean;
import be.helha.groupe3.entities.Produit;
import be.helha.groupe3.entities.Commande;
import be.helha.groupe3.entities.Panier;

@Named
@RequestScoped
public class PanierBeanController {

	private HashMap<Produit,Integer>mapProduit;
	private double prixtot;
	
	@EJB
	private DAOPanierLocalBean daoPanierLocalBean;
	
	//Getters & Setters 
	//-------------------------------------------
	
	public HashMap<Produit, Integer> getHashMap(){
		return mapProduit;
	}
	
	public void setMapProduit(HashMap<Produit,Integer> map){
		this.mapProduit=map;
	}
	
	public double getPrixTot(){
		return prixtot;
	}
	
	public void setPrixTot(double prixTot){
		this.prixtot=prixTot;
	}
	//---------------------------------------------
	
	//METHODE D'ACCES A LA BASE DE DONNEES
	//---------------------------------------------
	
	public void create(){
		Panier obj = new Panier(0.0);
		daoPanierLocalBean.create(obj);
	}
	
	public List<Panier> getAllPanier(){
		return daoPanierLocalBean.findAll();
	}
	
	public Panier find(long id){
		return daoPanierLocalBean.find(id);
	}
	
	public double getPrixPanier(){
		return daoPanierLocalBean.calculerPrixTot();
	}
	
	public void ajouterProduitPanier(){
		daoPanierLocalBean.addPanier();
	}
	
	public void retirerProduitPanier(){
		daoPanierLocalBean.removePanier();
	}
	
	public Commande validerPanier(){
		return daoPanierLocalBean.validatePanier();
	}
	
	public void cleanPanier(){
		daoPanierLocalBean.cleanPanier();
	}
}
	

