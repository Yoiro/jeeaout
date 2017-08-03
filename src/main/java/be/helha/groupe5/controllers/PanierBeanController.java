package be.helha.groupe5.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import be.helha.groupe5.daos.DAOPanierLocalBean;
import be.helha.groupe5.entities.Commande;
import be.helha.groupe5.entities.Panier;
import be.helha.groupe5.entities.Produit;

@ManagedBean
@SessionScoped
public class PanierBeanController implements Serializable{
	private final String sessionID = FacesContext.getCurrentInstance().getExternalContext().getSessionId(true);
	private Panier panier = new Panier();
	private HashMap<Produit,Integer>mapProduit = panier.getMapProduit();
	private double prixtot = 0.0;
	private int qte = 0;

	@EJB
	private DAOPanierLocalBean daoPanierLocalBean;

	//Getters & Setters 
	//-------------------------------------------

	public List<Map.Entry<Produit, Integer>> getProduits(){
		Set<Map.Entry<Produit, Integer>> productSet = mapProduit.entrySet();
		return new ArrayList<Map.Entry<Produit, Integer>>(productSet);
	}

	public HashMap<Produit, Integer> getMapProduit(){
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

	public int getNbProduits() {
		int qte = 0;
		for (Produit p: mapProduit.keySet()) {
			qte ++;
		}
		return qte;
	}
	
	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
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

	public void ajouterProduitPanier(Produit p){
		System.out.println(p.toString());
		System.out.println(qte);
		if(p != null && qte > 0) {
			//daoPanierLocalBean.addToCart(p, qte);
			System.out.println("added!");
		}
	}

	public void retirerProduitPanier(Produit p){
		if(panier.getMapProduit().containsKey(p))
			daoPanierLocalBean.removeFromCart(p);
	}

	public Commande validerPanier(){
		return daoPanierLocalBean.validatePanier();
	}

	public void cleanPanier(){
		daoPanierLocalBean.cleanPanier();
	}
}
