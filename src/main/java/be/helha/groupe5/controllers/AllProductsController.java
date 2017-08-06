package be.helha.groupe5.controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import be.helha.groupe5.daos.DAOPanierLocalBean;
import be.helha.groupe5.daos.DAOProduitLocalBean;
import be.helha.groupe5.entities.Panier;
import be.helha.groupe5.entities.Produit;
import be.helha.groupe5.patterns.DBObserver;

@ManagedBean
@SessionScoped
public class AllProductsController implements Serializable, DBObserver{
	private List<Produit> produits;
	private Panier panier;
	private int panierID;
	
	@EJB
	private DAOProduitLocalBean daoProduitLocalBean;
	
	@EJB
	private DAOPanierLocalBean daoPanierLocalBean;
	
	@PostConstruct
	public void init() {
		produits = daoProduitLocalBean.findAll();
		panier = daoPanierLocalBean.getPanier();
		panierID = panier.getId();
		daoPanierLocalBean.ajouterObserver(this);
	}

	//Getters & Setters
	//----------------------------------------------------
	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
	//----------------------------------------------------
	
	public String addToCart(String id) {
		Integer prodId = Integer.parseInt(id);
		Produit p = daoProduitLocalBean.findById((long)prodId);
		daoPanierLocalBean.addToCart(p, 1);
		return null;
	}

	@Override
	public void onUpdate() {
		// TODO Auto-generated method stub
		panier = daoPanierLocalBean.getPanier();
		
	}
}
