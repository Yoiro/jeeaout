package be.helha.groupe5.controllers;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;

import be.helha.groupe5.daos.DAOPanierLocalBean;
import be.helha.groupe5.entities.Commande;
import be.helha.groupe5.entities.Panier;
import be.helha.groupe5.entities.Produit;

@ManagedBean
@SessionScoped
public class PanierBeanController implements Serializable{

	private HashMap<Produit,Integer>mapProduit;
	private double prixtot;
	
	private Panier panier;
	
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
		return daoPanierLocalBean.findById(id);
	}
	
	public double getPrixPanier(){
		return daoPanierLocalBean.calculerPrixTot();
	}
	
	public void ajouterProduitPanier(Produit p, int qte){
		if(p!=null&&qte>0)
		daoPanierLocalBean.addPanier(p, qte);
	}
	
	public void retirerProduitPanier(Produit p){
		if(panier.getMapProduit().containsKey(p))
		daoPanierLocalBean.removePanier(p);
	}
	
	public Commande validerPanier(){
		return daoPanierLocalBean.validatePanier();
	}
	
	public void cleanPanier(){
		daoPanierLocalBean.cleanPanier();
	}
}
	

